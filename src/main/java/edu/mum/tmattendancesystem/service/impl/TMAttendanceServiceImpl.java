package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.TMAttendance;
import edu.mum.tmattendancesystem.repository.TMAttendanceRepository;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TMAttendanceServiceImpl implements TMAttendanceService {
    @Autowired
    TMAttendanceRepository tmAttendanceRepository;

    @Override
    public TMAttendance save(TMAttendance tmAttendance) {
        return tmAttendanceRepository.save(tmAttendance);
    }

    @Override
    public List<TMAttendance> findByStudentId(String id) {
        return tmAttendanceRepository.findByStudentId(id);
    }

    @Override
    public List<TMAttendance> findByStudentAndBlock(String id, LocalDate startDate, LocalDate endDate) {
        Map<LocalDate, Boolean> attendance = new HashMap<>();
        return tmAttendanceRepository.findByStudentAndBlock(id, startDate, endDate);
    }

    @Override
    public List<TMAttendance> findAttendanceOfAStudent(String studentId) {
        return tmAttendanceRepository.findAttendanceOfAStudent(studentId);
    }
}
