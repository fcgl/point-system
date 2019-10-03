package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.dataModel.UserTrophy;
import com.fcgl.madrid.points.payload.response.GetUserTrophyResponse;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import com.fcgl.madrid.points.payload.InternalStatus;
import com.fcgl.madrid.points.payload.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.lang.Exception;

import java.util.List;

@Service
public class UserTrophyService {
	private UserTrophyRepository userTrophyRepository;

	@Autowired
	public UserTrophyService(UserTrophyRepository userTrophyRepository) {
		this.userTrophyRepository = userTrophyRepository;
	}

	public List<UserTrophy> findAll() {
		return userTrophyRepository.findAll();
	}

	@CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
	public ResponseEntity<GetUserTrophyResponse> getUserTrophiesById(Long userId) {
		GetUserTrophyResponse getUserTrophyResponse = new GetUserTrophyResponse(InternalStatus.OK, userTrophyRepository.getUserTrophiesById(userId));
		return new ResponseEntity<GetUserTrophyResponse>(getUserTrophyResponse,	HttpStatus.OK);
	}

	private ResponseEntity<GetUserTrophyResponse> fallback(Long userId, Exception ex) {
		String message = "Fallback: " + ex.getMessage();
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
		GetUserTrophyResponse postResponse = new GetUserTrophyResponse(internalStatus, null);
		return new ResponseEntity<GetUserTrophyResponse>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
