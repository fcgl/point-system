package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.dataModel.UserTrophy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import java.util.Optional;

@Repository
public interface UserTrophyRepository extends JpaRepository<UserTrophy, Long> {

  @Query("SELECT u FROM UserTrophy u WHERE u.userId = ?1")
    List<UserTrophy> getUserTrophiesById(Long id);

    Optional<UserTrophy> getByUserId(Long userId);
}
