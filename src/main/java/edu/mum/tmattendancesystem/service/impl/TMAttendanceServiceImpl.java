package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.TMAttendance;
import edu.mum.tmattendancesystem.repository.TMAttendanceRepository;
import edu.mum.tmattendancesystem.service.TMAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public List<TMAttendance> findAttendanceOfAStudent(String studentId) {
        return tmAttendanceRepository.findAttendanceOfAStudent(studentId);
    }
}
