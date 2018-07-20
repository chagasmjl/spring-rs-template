package br.com.springrstemplate.log;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@RestController
public class LogController {
	
	@Autowired
	private LogRepository rep;

	@RequestMapping(name="/logs",method=RequestMethod.GET)
	@JsonInclude(Include.NON_EMPTY)
	public Collection<LogEntity> getLog() {
		return rep.findAll();
		
	}
	
	/** POST	 */
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public LogEntity saveLog(@RequestBody LogEntity log) {
	 return rep.save(log);
	}

}
