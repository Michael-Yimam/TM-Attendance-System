package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.CourseEnrollment;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.repository.CourseEnrollmentRepository;
import edu.mum.tmattendancesystem.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    @Autowired
    CourseEnrollmentRepository repository;

    public List<CourseEnrollment> findAllByCourse(CourseOffer course){
        return repository.findAllByCourse(course);
    }

}
