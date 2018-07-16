package br.com.springrstemplate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springrstemplate.entity.Log;

public interface LogRepository extends JpaRepository<Log, String>{
	List<Log> findAll();
}
