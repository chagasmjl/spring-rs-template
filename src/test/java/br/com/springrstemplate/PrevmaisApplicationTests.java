package br.com.springrstemplate;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springrstemplate.controller.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrevmaisApplicationTests {

	@Autowired
	private LoggerController loggerController;
	
	@Test
	public void contextLoads() {
		assertThat(loggerController).isNotNull() ;
	}

}
