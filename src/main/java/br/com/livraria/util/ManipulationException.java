package br.com.livraria.util;

public class ManipulationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ManipulationException(String msg) {
		super(msg);
	}
	
	public ManipulationException(String message, Throwable e) {
		super(message, e);
	}
	
	public ManipulationException(Throwable e) {
		super(e);
	}
}
