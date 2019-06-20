package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.CourseEnrollment;
import edu.mum.tmattendancesystem.domain.Student;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import edu.mum.tmattendancesystem.repository.StudentRepository;
import edu.mum.tmattendancesystem.service.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BlockService blockService;

    @Autowired
    CourseEnrollmentService enrollmentService;

    @Autowired
    CourseOfferService courseOfferService;

    @Autowired
    TMAttendanceService attendanceService;

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findAllByEntry(String entry) {
        return studentRepository.findAllByEntry(entry);
    }

    @Override
    public Map<String, String> findEntryReport(String entry) {
        // Find students by Entry;
        List<Student> students = studentRepository.findAllByEntry(entry);

        // For each student, find the course he enrolled;

        Map<String, String> report = new HashMap<>();
        for(Student st: students){
            int sessionCount = 0;
            List<CourseEnrollment> enrollments = enrollmentService.findAllByStudentId(st.getId());

            System.out.println("Student Id: " + st.getId());
            System.out.println("Number of Enrollments: " + enrollments.size());
            for(CourseEnrollment c: enrollments){
                sessionCount += c.getCourse().getBlock().getNumberOfMeditation();
            }
            int attendanceCount = attendanceService.findByStudentId(st.getId()).size();
            System.out.println("Number of Attendance: " + attendanceCount);
            System.out.println("Possible of Attendance: " + sessionCount);
            DecimalFormat format = new DecimalFormat();
            format.setMaximumFractionDigits(2);
            if(sessionCount > 0 ) {
                //(float)attendanceCount/sessionCount)*100.0
                String result = format.format((((float) attendanceCount / sessionCount) * 100));
                report.put(st.getId(), result);
            }
        }

        return report;
    }
}
