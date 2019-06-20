package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.domain.Faculty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseOfferRepository extends CrudRepository<CourseOffer, String>{
    List<CourseOffer> findAllByFaculty(Faculty faculty);
    List<CourseOffer> findAll();


}