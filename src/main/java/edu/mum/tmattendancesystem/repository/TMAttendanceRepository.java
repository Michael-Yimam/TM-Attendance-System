package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import org.springframework.data.repository.CrudRepository;

public interface TMAttendanceRepository extends CrudRepository<TMAttendance, AttendanceKey> {
}
