package br.com.springrstemplate;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Classe que trata as exceções lançadas do tipo especificado em @ExceptionHandler
 * 
 *  This class get all the application exceptions and treat accordaccordingly
 */
@RestControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= { 
			IllegalArgumentException.class, 
			IllegalStateException.class, 
			HttpClientErrorException.class,
			Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
        
    }
	
	
}
