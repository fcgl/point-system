package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.payload.response.GetUserPointsResponse;
import com.fcgl.madrid.points.dataModel.UserPoint;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import com.fcgl.madrid.points.payload.InternalStatus;
import com.fcgl.madrid.points.payload.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

import java.lang.Exception;

@Service
public class UserPointsService {
	private UserPointsRepository userPointsRepository;

	@Autowired
	public UserPointsService(UserPointsRepository userPointsRepository) {
		this.userPointsRepository = userPointsRepository;
	}

	public List<UserPoint> findAll() {
		return userPointsRepository.findAll();
	}

	@CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
	public ResponseEntity<GetUserPointsResponse> getUserPointsById(Long userId) {
		GetUserPointsResponse getUserPointResponse = new GetUserPointsResponse(InternalStatus.OK, userPointsRepository.getUserPointsById(userId));
		return  new ResponseEntity<GetUserPointsResponse>(getUserPointResponse, HttpStatus.OK);
	}

	private ResponseEntity<GetUserPointsResponse> fallback(Long userId, Exception ex) {
		String message = "Fallback: " + ex.getMessage();
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
		UserPoint userPoint = getUserPointsById(userId).getBody().getUserPoint();
		GetUserPointsResponse postResponse = new GetUserPointsResponse(internalStatus, userPoint);
		return new ResponseEntity<GetUserPointsResponse>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
