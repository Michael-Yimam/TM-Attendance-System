package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.domain.TMAttendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TMAttendanceService {
    public TMAttendance save(TMAttendance tmAttendance);

    public List<TMAttendance> findAttendanceOfAStudent(String studentId);
    List<TMAttendance> findByStudentId(String id);
    public Map<LocalDate, Boolean> findByStudentAndBlock(String studentId, Block block);
    Double findExtraCredit(String studentId, Block block);
    Map<String, Double> findBlockReport(String courseId, Block block);

}
