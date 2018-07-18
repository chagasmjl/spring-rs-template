package br.com.springrstemplate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.springrstemplate.entity.Log;
import br.com.springrstemplate.repository.LogRepository;

@RestController
public class LoggerController {
	
	@Autowired
	private LogRepository rep;

	@RequestMapping(name="/logs",method=RequestMethod.GET)
	@JsonInclude(Include.NON_EMPTY)
	public Collection<Log> getLog() {
		return rep.findAll();
		
	}
	
	/** POST	 */
	@PostMapping
	public void saveLog(@RequestBody Log log) {
		rep.save(log);
	}

}
