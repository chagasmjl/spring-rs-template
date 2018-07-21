package br.com.springrstemplate.log;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class LogRepositoryImpl implements LogRepository {

	@Override
	public <S extends LogEntity> List<S> findAll(Example<S> example) {
		
		return null;
	}

}
