package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.CourseEnrollment;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseEnrollmentRepository extends CrudRepository<CourseEnrollment, Integer> {
    List<CourseEnrollment> findAllByStudentIdAndCourseId(String studentId, String courseId);
    List<CourseEnrollment> findAllByCourse(CourseOffer course);
}
