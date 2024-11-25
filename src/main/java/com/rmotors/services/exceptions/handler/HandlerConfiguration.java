package com.rmotors.services.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerConfiguration {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<HandlerException> violacaoDeDuplicidade(DataIntegrityViolationException DIVE, HttpServletRequest req){
		HandlerException handlerException = new HandlerException(LocalDateTime.now(), HttpStatus.BAD_REQUEST, new HandlerMessage().getMessage(), "Recurso não pode ser inserido", req.getRequestURI());
		return new ResponseEntity<HandlerException>(handlerException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<HandlerException> caracterNaoEsperado(HttpMessageNotReadableException HMNRE, HttpServletRequest req){
		HandlerException He = new HandlerException(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Erro na digitação ou falta de campos a ser inserido" , "Recurso não pode ser inserido", req.getRequestURI());
		return new ResponseEntity<>(He, HttpStatus.BAD_REQUEST);
	}
}
