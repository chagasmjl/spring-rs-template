package br.com.springrstemplate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.springrstemplate.log.LogController;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class PrevmaisApplicationTests {
	
	@Autowired
	private LogController controller;
	@LocalServerPort
	private int port;
	@Autowired
	private RestTemplate template;
	
	
	//@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	//@Test
	public void getShouldReturnSomething() throws Exception{
		
		assertThat(template.getForObject("http://localhost:" + port + "/",
                String.class)).contains("dsyer");

	}
	
	

}
