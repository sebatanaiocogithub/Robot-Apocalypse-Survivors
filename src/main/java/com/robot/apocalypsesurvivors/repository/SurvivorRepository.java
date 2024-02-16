package com.robot.apocalypsesurvivors.repository;

import com.robot.apocalypsesurvivors.entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
    long countByInfectedTrue();
    List<Survivor> findByInfectedTrue();
    List<Survivor> findByInfectedFalse();
}
