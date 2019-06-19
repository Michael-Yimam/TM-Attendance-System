package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.domain.CourseOffer;
import edu.mum.tmattendancesystem.domain.Faculty;
import edu.mum.tmattendancesystem.repository.BlockRepository;
import edu.mum.tmattendancesystem.repository.CourseOfferRepository;
import edu.mum.tmattendancesystem.service.BlockService;
import edu.mum.tmattendancesystem.service.CourseOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseOfferServiceImpl implements CourseOfferService {

    @Autowired
    CourseOfferRepository courseOfferRepository;

    @Autowired
    BlockRepository blockRepository;

    @Override
    public List<CourseOffer> findAllByFaculty(Faculty faculty) {
        return courseOfferRepository.findAllByFaculty(faculty);
    }

    @Override
    public Block findBlockByCourseId(String courseId) {
        CourseOffer course = courseOfferRepository.findById(courseId).get();
        return course.getBlock();
    }

}
