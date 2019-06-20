package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.*;
import edu.mum.tmattendancesystem.repository.CourseEnrollmentRepository;
import edu.mum.tmattendancesystem.repository.CourseOfferRepository;
import edu.mum.tmattendancesystem.repository.TMAttendanceRepository;
import edu.mum.tmattendancesystem.service.BlockService;
import edu.mum.tmattendancesystem.service.MeditationService;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class TMAttendanceServiceImpl implements TMAttendanceService {
    @Autowired
    TMAttendanceRepository tmAttendanceRepository;

    @Autowired
    MeditationService meditationService;

    @Autowired
    BlockService blockService;

    @Autowired
    CourseEnrollmentRepository enrollmentRepository;

    @Autowired
    CourseOfferRepository courseOfferRepository;
    @Override
    public TMAttendance save(TMAttendance tmAttendance) {
        return tmAttendanceRepository.save(tmAttendance);
    }

    @Override
    public List<TMAttendance> findByStudentId(String id) {
        return tmAttendanceRepository.findByStudentId(id);
    }

    @Override
    public Map<LocalDate, Boolean> findByStudentAndBlock(String studentId, Block block) {
        List<Meditation> tmSessions = new ArrayList<>();
        tmSessions = meditationService.findByBlock(block.getName());

        List<TMAttendance> attendance =  tmAttendanceRepository.findByStudentAndBlock(studentId,
                block.getStartDate(), block.getEndDate());

        System.out.println("In Attendance Service impl, method: findByStudentAndBlock");
        Map<LocalDate, Boolean> report = new HashMap<>();
        for(Meditation tm: tmSessions){
            report.put(tm.getDate(), false);
        }
        System.out.println("Number of Attended Dates:" + attendance.size());
        for(TMAttendance att: attendance){
            report.replace(att.getAttendanceKey().getDate(), true);
            System.out.println(att.getAttendanceKey().getDate());

        }

        return report;
    }

    @Override
    public Double findExtraCredit(String studentId, Block block) {
        int totalSessions = block.getNumberOfMeditation();
        int attended =  tmAttendanceRepository.findByStudentAndBlock(studentId,
                block.getStartDate(), block.getEndDate()).size();
        double ratio = 100 * attended/totalSessions;
        if(ratio>= 90)
            return 1.5;
        else if(ratio >= 80)
            return 1.0;
        else if(ratio >= 70)
            return 0.5;
        else
            return 0.0;
    }

    @Override
    public Map<String, Double> findBlockReport(String courseId, Block block) {
        Map<String, Double> blockReport = new HashMap<>();
        CourseOffer course = courseOfferRepository.findById(courseId).get();
        System.out.println("Course Id: " + course.getId());
        List<CourseEnrollment> enrollments = enrollmentRepository.findAllByCourse(course);
        System.out.println("Number of Enrollments: " + enrollments.size());
       for(CourseEnrollment e: enrollments){
           String studentId = e.getStudent().getId();
           blockReport.put(studentId, findExtraCredit(studentId, block) );
       }
        return blockReport;
    }

    @Override
    public List<TMAttendance> findAttendanceOfAStudent(String studentId) {

        return tmAttendanceRepository.findAttendanceOfAStudent(studentId);
    }
}
