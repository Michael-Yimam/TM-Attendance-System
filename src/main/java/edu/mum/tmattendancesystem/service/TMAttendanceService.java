package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.TMAttendance;

import java.time.LocalDate;
import java.util.List;

public interface TMAttendanceService {
    public TMAttendance save(TMAttendance tmAttendance);

    public List<TMAttendance> findAttendanceOfAStudent(String studentId);
    List<TMAttendance> findByStudentId(String id);
    public List<TMAttendance> findByStudentAndBlock(String id, LocalDate startDate, LocalDate endDate);

}
