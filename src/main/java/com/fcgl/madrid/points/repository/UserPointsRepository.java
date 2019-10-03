package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.dataModel.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPointsRepository extends JpaRepository<UserPoint, Long> {
  @Query("SELECT u FROM UserPoint u WHERE u.userId = ?1")
  UserPoint getUserPointsById(Long id);

  Optional<UserPoint> getByUserId(Long userId);
}
