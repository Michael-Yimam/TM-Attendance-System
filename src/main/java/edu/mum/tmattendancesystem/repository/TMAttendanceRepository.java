package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, AttendanceKey> {

    public TMAttendance save(TMAttendance tmAttendance);
}
