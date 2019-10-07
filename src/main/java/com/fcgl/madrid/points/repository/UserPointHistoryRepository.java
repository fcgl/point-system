package com.fcgl.madrid.points.repository;

import com.fcgl.madrid.points.dataModel.UserPointHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserPointHistoryRepository extends JpaRepository<UserPointHistory, Long> {

    List<UserPointHistory> findUserPointHistoryByUserId(Long userId, Pageable pageable);

}
