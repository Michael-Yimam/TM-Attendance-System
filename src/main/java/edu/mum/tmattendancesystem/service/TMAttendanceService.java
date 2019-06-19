package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TMAttendanceService {
    public TMAttendance save(TMAttendance tmAttendance);

    List<TMAttendance> findByStudentId(String id);
    public List<TMAttendance> findByStudentAndBlock(String id, LocalDate startDate, LocalDate endDate);

}
