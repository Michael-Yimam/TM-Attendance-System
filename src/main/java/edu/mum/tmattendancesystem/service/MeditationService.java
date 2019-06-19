package edu.mum.tmattendancesystem.service;

import edu.mum.tmattendancesystem.domain.Meditation;

import java.util.List;

public interface MeditationService {
    List<Meditation> findByBlock(String blockId);
}
