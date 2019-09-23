package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.Action;
import com.fcgl.madrid.points.model.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserActionRepository extends JpaRepository<UserAction, Long> {
    Optional<UserAction> findByUserIdAndAction(Long userId, Action action);
}
