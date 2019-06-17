package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {

}
