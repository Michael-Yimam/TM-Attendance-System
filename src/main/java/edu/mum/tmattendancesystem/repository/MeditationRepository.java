package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Meditation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface MeditationRepository extends CrudRepository<Meditation, LocalDate> {
}
