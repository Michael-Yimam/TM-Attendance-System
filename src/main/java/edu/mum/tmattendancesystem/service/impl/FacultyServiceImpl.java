package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Faculty;
import edu.mum.tmattendancesystem.repository.FacultyRepository;
import edu.mum.tmattendancesystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty findById(String id) {
        return facultyRepository.findById(id).get();
    }
}
