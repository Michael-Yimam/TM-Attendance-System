package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, String> {

}
