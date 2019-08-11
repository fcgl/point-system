package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.model.UserTrophy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrophyRepository extends JpaRepository<UserTrophy, Long> {

}