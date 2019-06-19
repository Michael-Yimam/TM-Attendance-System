package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Admin;
import edu.mum.tmattendancesystem.repository.AdminRepository;
import edu.mum.tmattendancesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id).get();
    }
}
