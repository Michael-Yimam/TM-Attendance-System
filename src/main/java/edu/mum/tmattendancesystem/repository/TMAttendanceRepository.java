package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, AttendanceKey> {

    public TMAttendance save(TMAttendance tmAttendance);

    @Query(value = "SELECT * FROM TMATTENDANCE WHERE STUDENT_ID= ?1", nativeQuery= true)
    List<TMAttendance> findAttendanceOfAStudent(String studentId);
}
