package br.com.springrstemplate;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import br.com.springrstemplate.log.LogEntity;
import br.com.springrstemplate.log.LogRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringrstemplateApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringrstemplateApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(LogRepository logRepository) {
		return args ->
		Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
			//.forEach(username -> {
				.forEach(logName -> {
					//bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
					logRepository.save(new LogEntity(logName, logName +"_request"));
				});
	}
}
