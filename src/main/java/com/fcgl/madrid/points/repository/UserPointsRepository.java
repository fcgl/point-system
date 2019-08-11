package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.UserPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointsRepository extends JpaRepository<UserPoints, Long> {

}
