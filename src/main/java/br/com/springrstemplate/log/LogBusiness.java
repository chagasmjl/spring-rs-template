package br.com.springrstemplate.log;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

/**
 * Classe que representa o negócio onde as regras são de fato implementadas
 * </br></br>
 * Business class where de business logic happens
 */
@Component
public class LogBusiness {
	
	@Autowired
	private LogRepository repository;
	
	public Collection<?> getAllLogs() {
		return repository.findAll();
	}
	
	/**
	 * Using {@link Example} and {@link ExampleMatcher} to filter data from database
	 * See:  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example
	 * 
	 * @param filter
	 * @return
	 */
	public Collection<?> getLogs(LogEntity filter) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
		//		  .withIgnorePaths("request")                         
		//		  .withIncludeNullValues()                             
				  .withIgnoreCase();                          
		Example<LogEntity> example = Example.of(filter, matcher);
		return repository.findAll(example);
	}
	
	public LogEntity save(LogEntity logEntity) {
		if (logEntity.getId() == null) logEntity.setId(UUID.randomUUID().toString());
		return repository.save(logEntity);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
}
