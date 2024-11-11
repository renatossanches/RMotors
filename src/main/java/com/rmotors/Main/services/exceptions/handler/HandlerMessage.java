package com.rmotors.Main.services.exceptions.handler;

public class HandlerMessage extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public HandlerMessage() {
		super("Objeto já existe no banco de dados");
	}
	
}
