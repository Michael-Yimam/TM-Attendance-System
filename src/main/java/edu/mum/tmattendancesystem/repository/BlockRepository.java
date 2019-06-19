package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends CrudRepository<Block, String> {
    List<Block> findAll();
}
