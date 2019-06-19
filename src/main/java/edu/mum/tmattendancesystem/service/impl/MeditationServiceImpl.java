package edu.mum.tmattendancesystem.service.impl;

import edu.mum.tmattendancesystem.domain.Meditation;
import edu.mum.tmattendancesystem.repository.MeditationRepository;
import edu.mum.tmattendancesystem.service.MeditationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MeditationServiceImpl implements MeditationService {

    @Autowired
    MeditationRepository meditationRepository;

    @Override
    public List<Meditation> findByBlock(String blockId) {
        return meditationRepository.findByBlock(blockId);
    }
}
