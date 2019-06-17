package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
