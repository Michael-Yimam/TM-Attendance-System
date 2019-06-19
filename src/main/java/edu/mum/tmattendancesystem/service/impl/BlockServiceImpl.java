package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Block;
import edu.mum.tmattendancesystem.repository.BlockRepository;
import edu.mum.tmattendancesystem.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }
}
