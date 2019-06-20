package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.CourseEnrollment;
import edu.mum.tmattendancesystem.domain.CourseOffer;

import java.util.List;

public interface CourseEnrollmentService {
    List<CourseEnrollment> findAllByCourse(CourseOffer course);

    List<CourseEnrollment> findAllByStudentId(String id);

}
