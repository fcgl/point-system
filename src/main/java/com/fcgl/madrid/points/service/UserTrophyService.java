package com.fcgl.madrid.points.service;

import com.fcgl.madrid.points.model.UserTrophy;
import com.fcgl.madrid.points.repository.UserTrophyRepository;
import com.fcgl.madrid.points.model.InternalStatus;
import com.fcgl.madrid.points.model.StatusCode;
import com.fcgl.madrid.points.model.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

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

	@Autowired
	public UserTrophyService(UserTrophyRepository userTrophyRepository) {
		this.userTrophyRepository = userTrophyRepository;
	}

	public List<UserTrophy> findAll() {
		return userTrophyRepository.findAll();
	}

	public List<UserTrophy> getUserTrophiesById(Long userId) {
		return userTrophyRepository.getUserTrophiesById(userId);
	}

}
