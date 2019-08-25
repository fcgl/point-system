package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserPoint;
import com.fcgl.madrid.points.repository.UserPointsRepository;
import com.fcgl.madrid.points.model.InternalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.lang.Exception;
import java.lang.Throwable;
import java.lang.StringBuilder;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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

  /*  @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
    public ResponseEntity<InternalStatus> get(PostRequest);*/
}
