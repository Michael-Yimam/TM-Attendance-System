package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Student;
import edu.mum.tmattendancesystem.repository.StudentRepository;
import edu.mum.tmattendancesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).get();
    }
}
