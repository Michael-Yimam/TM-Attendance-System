package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.TmAttendanceSystemApplication;
import edu.mum.tmattendancesystem.domain.AttendanceKey;
import edu.mum.tmattendancesystem.domain.TMAttendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TMAttendanceRepository extends CrudRepository<TMAttendance, AttendanceKey> {

    public TMAttendance save(TMAttendance tmAttendance);

    @Query(value = "Select * from TMAttendance where Student_Id =:id AND " +
            "DATE between :startDate And :endDate", nativeQuery = true)
    List<TMAttendance> findByStudentAndBlock(@Param("id") String id, @Param("startDate")LocalDate startDate,
                                       @Param("endDate") LocalDate endDate);
    @Query(value = "Select * from TMAttendance where STUDENT_ID =:id", nativeQuery = true)
    List<TMAttendance> findByStudentId(@Param("id")  String id);
}
