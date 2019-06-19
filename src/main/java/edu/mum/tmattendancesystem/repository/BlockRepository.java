package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Block;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlockRepository extends CrudRepository<Block, String> {

    List<Block> findAll();
}
