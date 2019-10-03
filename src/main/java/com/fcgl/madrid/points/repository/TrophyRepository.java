package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.dataModel.Action;
import com.fcgl.madrid.points.dataModel.Trophy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrophyRepository extends JpaRepository<Trophy, Long> {
    Optional<Trophy> findByAction(Action action);
}
