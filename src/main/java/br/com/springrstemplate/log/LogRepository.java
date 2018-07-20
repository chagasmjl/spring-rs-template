package br.com.springrstemplate.log;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends JpaRepository<LogEntity, String>{
	List<LogEntity> findAll();
}
