package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
//    @Query(value = "SELECT s FROM Student s WHERE s.id= :id")
//    Optional<Student> findById(String id);
}
