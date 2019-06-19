package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.TMAttendance;

import java.util.List;

public interface TMAttendanceService {
    public TMAttendance save(TMAttendance tmAttendance);
    public List<TMAttendance> findAttendanceOfAStudent(String studentId);
}
