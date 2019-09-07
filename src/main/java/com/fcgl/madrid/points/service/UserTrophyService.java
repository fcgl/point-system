package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.model.response.GetUserTrophyResponse;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import com.fcgl.madrid.points.model.InternalStatus;
import com.fcgl.madrid.points.model.StatusCode;
import com.fcgl.madrid.points.model.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.lang.Exception;
import java.lang.Throwable;
import java.lang.StringBuilder;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserTrophyService {
	private UserTrophyRepository userTrophyRepository;
	private GetUserTrophyResponse getUserTrophyResponse;

	@Autowired
	public UserTrophyService(UserTrophyRepository userTrophyRepository) {
		this.userTrophyRepository = userTrophyRepository;
	}

	public List<UserTrophy> findAll() {
		return userTrophyRepository.findAll();
	}

	public GetUserTrophyResponse getUserTrophiesById(Long userId) {
		getUserTrophyResponse.setUserTrophies(userTrophyRepository.getUserTrophiesById(userId));
		return getUserTrophyResponse;
	}


	/**
	 *
	 * @param ex Exception
	 * @return ResponseEntity<InternalStatus>
	 */
	@CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
	private ResponseEntity<GetUserTrophyResponse> fallback(Long userId, Exception ex) {
		String message = "Fallback: " + ex.getMessage();
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
		GetUserTrophyResponse postResponse = new GetUserTrophyResponse(internalStatus, null, null);
		return new ResponseEntity<GetUserTrophyResponse>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
