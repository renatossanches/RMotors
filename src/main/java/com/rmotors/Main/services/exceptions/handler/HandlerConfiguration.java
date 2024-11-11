package com.rmotors.Main.services.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerConfiguration {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<HandlerException> violacaoDeDuplicidade(DataIntegrityViolationException DIVE, HttpServletRequest req){
		HandlerException handlerException = new HandlerException(LocalDateTime.now(), HttpStatus.BAD_REQUEST, new HandlerMessage().getMessage(), "Recurso não pode ser inserido", req.getRequestURI());
		return new ResponseEntity<HandlerException>(handlerException, HttpStatus.BAD_REQUEST);
	
	}
}
