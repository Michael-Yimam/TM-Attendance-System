package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Block;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface BlockService {
    List<Block> findAll();
}
