package com.fcgl.madrid.points.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.fcgl.madrid.points.payload.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import com.fcgl.madrid.points.payload.InternalStatus;

public class ExceptionUtil {

	public ResponseEntity<InternalStatus> handleParamException(TransactionSystemException e) {
		return getInternalStatusResponseEntity(e);
	}

	public ResponseEntity<InternalStatus> getInternalStatusResponseEntity(TransactionSystemException e) {
		Throwable cause = e.getRootCause();
		if (cause instanceof ConstraintViolationException) {
			Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause)
					.getConstraintViolations();
			List<String> messages = new ArrayList<String>();
			for (ConstraintViolation v : constraintViolations) {
				StringBuilder builder = new StringBuilder("");
				builder.append(v.getPropertyPath().toString());
				builder.append(" ");
				builder.append(v.getMessage());
				messages.add(builder.toString());
			}
			InternalStatus internalStatus = new InternalStatus(StatusCode.PARAM, 400, messages);
			return new ResponseEntity<InternalStatus>(internalStatus, HttpStatus.BAD_REQUEST);
		}
		InternalStatus internalStatus = new InternalStatus(StatusCode.UNKNOWN, 500, e.getMessage());
		return new ResponseEntity<InternalStatus>(internalStatus, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
