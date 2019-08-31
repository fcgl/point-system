package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPointsRepository extends JpaRepository<UserPoint, Long> {
  @Query("SELECT u FROM UserPoint u WHERE u.userId = ?1")
    List<UserPoint> getUserPointsById(Long id);

}
