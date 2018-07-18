package br.com.springrstemplate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springrstemplate.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, String>{
	List<Log> findAll();
}
