package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.TMChecking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMCheckingRepository extends CrudRepository<TMChecking, Long> {

}
