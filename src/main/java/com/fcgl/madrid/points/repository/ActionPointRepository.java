package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionPointRepository extends JpaRepository<Action, Long> {
}
