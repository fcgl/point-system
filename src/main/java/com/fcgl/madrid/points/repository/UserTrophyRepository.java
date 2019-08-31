package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.controller.UserTrophyController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface UserTrophyRepository extends JpaRepository<UserTrophy, Long> {
  @Query("SELECT u FROM UserTrophy u WHERE u.userId = ?1")
    List<UserTrophy> findByID(Long id);
}
