package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.dataModel.UserPointHistory;
import com.fcgl.madrid.points.payload.request.GetUserPointHistory;
import com.fcgl.madrid.points.payload.response.GetUserPointsResponse;
import com.fcgl.madrid.points.dataModel.UserPoint;
import com.fcgl.madrid.points.payload.response.Response;
import com.fcgl.madrid.points.repository.UserPointHistoryRepository;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import com.fcgl.madrid.points.payload.InternalStatus;
import com.fcgl.madrid.points.payload.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

import java.lang.Exception;

@Service
public class UserPointsService {
	private UserPointsRepository userPointsRepository;
	private UserPointHistoryRepository userPointHistoryRepository;

	@Autowired
	public UserPointsService(UserPointsRepository userPointsRepository, UserPointHistoryRepository userPointHistoryRepository) {
		this.userPointsRepository = userPointsRepository;
		this.userPointHistoryRepository = userPointHistoryRepository;
	}

	public List<UserPoint> findAll() {
		return userPointsRepository.findAll();
	}

	@CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
	public ResponseEntity<GetUserPointsResponse> getUserPointsById(Long userId) {
		GetUserPointsResponse getUserPointResponse = new GetUserPointsResponse(InternalStatus.OK, userPointsRepository.getUserPointsById(userId));
		return  new ResponseEntity<GetUserPointsResponse>(getUserPointResponse, HttpStatus.OK);
	}

	public ResponseEntity<Response<List>> getUserPointHistory(GetUserPointHistory request) {
		Pageable pageConfig = PageRequest.of(request.getPage(), request.getSize());
		List<UserPointHistory> body = userPointHistoryRepository.findUserPointHistoryByUserId(request.getUserId(), pageConfig);
		Response<List> response = new Response<>(InternalStatus.OK, body);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private ResponseEntity<GetUserPointsResponse> fallback(Long userId, Exception ex) {
		String message = "Fallback: " + ex.getMessage();
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, message);
		UserPoint userPoint = getUserPointsById(userId).getBody().getUserPoint();
		GetUserPointsResponse postResponse = new GetUserPointsResponse(internalStatus, userPoint);
		return new ResponseEntity<GetUserPointsResponse>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
