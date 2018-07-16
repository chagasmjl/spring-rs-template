package br.com.springrstemplate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrstemplate.LogRepository;
import br.com.springrstemplate.entity.Log;

@RestController
@RequestMapping("/log/")
public class LoggerController {
	
	@Autowired
	private LogRepository rep;
	
	@GetMapping
	public Collection<Log> getLog() {
		return rep.findAll();
		
	}
	
	@PostMapping
	public void saveLog(@RequestBody Log log) {
		rep.save(log);
	}

}
