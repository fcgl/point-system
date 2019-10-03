package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.payload.response.GetUserDataResponse;
import com.fcgl.madrid.points.payload.response.GetUserPointsResponse;
import com.fcgl.madrid.points.dataModel.UserPoint;
import com.fcgl.madrid.points.payload.response.Response;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import com.fcgl.madrid.points.payload.InternalStatus;
import com.fcgl.madrid.points.payload.StatusCode;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

import java.lang.Exception;
import java.util.Optional;

@Service
public class UserService {
    private UserPointsRepository userPointsRepository;
    private UserTrophyRepository userTrophyRepository;

    @Autowired
    public UserService(UserPointsRepository userPointsRepository, UserTrophyRepository userTrophyRepository) {
        this.userPointsRepository = userPointsRepository;
        this.userTrophyRepository = userTrophyRepository;
    }

    @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
    public ResponseEntity<Response> getUserData(Long userId) {
        UserPoint userPoint = null;
        Optional<UserPoint> optionalUserPoint = userPointsRepository.getByUserId(userId);
        if (!optionalUserPoint.isPresent()) {
            UserPoint newUserPoint = new UserPoint(userId, 0, 0);
            userPointsRepository.save(newUserPoint);
            userPoint = newUserPoint;
        } else {
            userPoint = optionalUserPoint.get();
        }
        Integer trophyCount = userTrophyRepository.countByUserId(userId);
        GetUserDataResponse userDataResponse = new GetUserDataResponse(
                userPoint.getTotalPoints(),
                userPoint.getTournamentPoints(),
                trophyCount
        );
        Response<GetUserDataResponse> response = new Response<>(InternalStatus.OK, userDataResponse);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ResponseEntity<Response> fallback(Long userId, Exception ex) {
        String message = "Fallback: " + ex.getMessage();
        InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
        Response response = new Response<>(internalStatus, null);
        return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
