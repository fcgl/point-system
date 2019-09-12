package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.response.GetUserPointsResponse;
import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import com.fcgl.madrid.points.model.InternalStatus;
import com.fcgl.madrid.points.model.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.lang.Exception;
import java.lang.Throwable;
import java.lang.StringBuilder;

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
	public GetUserPointsResponse getUserPointsById(Long userId) {
		return  new GetUserPointsResponse(InternalStatus.OK, userPointsRepository.getUserPointsById(userId));
	}

	private ResponseEntity<GetUserPointsResponse> fallback(Long userId, Exception ex) {
		String message = "Fallback: " + ex.getMessage();
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
		GetUserPointsResponse postResponse = new GetUserPointsResponse(internalStatus, getUserPointsById(userId).getUserPoint());
		return new ResponseEntity<GetUserPointsResponse>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
