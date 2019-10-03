package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.dataModel.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

}
