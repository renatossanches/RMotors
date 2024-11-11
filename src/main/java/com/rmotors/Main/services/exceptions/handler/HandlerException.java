package com.rmotors.Main.services.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter	
public class HandlerException {

	private LocalDateTime date;
	private HttpStatus status;
	private String message;
	private String error;
	private String path;
	
}
