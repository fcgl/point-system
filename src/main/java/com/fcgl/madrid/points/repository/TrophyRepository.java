package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.Trophy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrophyRepository extends JpaRepository<Trophy, Long> {

}
