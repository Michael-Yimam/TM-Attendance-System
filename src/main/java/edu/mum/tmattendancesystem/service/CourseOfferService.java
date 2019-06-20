package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.domain.Faculty;

import java.util.List;

public interface CourseOfferService {

    List<CourseOffer> findAllByFaculty(Faculty faculty);
    Block findBlockByCourseId(String id);
    CourseOffer findById(String id);
    List<CourseOffer> findAll();

}
