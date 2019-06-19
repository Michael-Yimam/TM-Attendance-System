package edu.mum.tmattendancesystem.repository;

import edu.mum.tmattendancesystem.domain.Meditation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MeditationRepository extends CrudRepository<Meditation, LocalDate> {
    @Query(value = "SELECT * FROM MEDITATION WHERE BLOCK_BLOCK_ID= ?1 AND TYPE = 'REGULAR'", nativeQuery= true)
    List<Meditation> findByBlock(String blockId);

}
