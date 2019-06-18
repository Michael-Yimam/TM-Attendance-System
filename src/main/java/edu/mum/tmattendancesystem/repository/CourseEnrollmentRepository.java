package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.CourseEnrollment;
import org.springframework.data.repository.CrudRepository;

public interface CourseEnrollmentRepository extends CrudRepository<CourseEnrollment, Integer> {
}
