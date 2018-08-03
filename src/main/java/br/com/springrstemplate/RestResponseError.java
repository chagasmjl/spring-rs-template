package br.com.springrstemplate;

import java.util.Map;
import org.springframework.http.HttpStatus;

public class RestResponseError {
	
	private HttpStatus httpStatus;
	private String	message;
	private Map<String,String> erros;
	
	public RestResponseError(HttpStatus httpStatus, String message, Map<String, String> erros) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.erros = erros;
	}
	
	public RestResponseError(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getErros() {
		return erros;
	}
	public void setErros(Map<String, String> erros) {
		this.erros = erros;
	}
	
	
	

}
