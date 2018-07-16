package br.com.springrstemplate;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.springrstemplate.entity.Log;

@SpringBootApplication
public class SpringRsTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRsTemplateApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(LogRepository logRepository) {
		return args ->
			Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
				.forEach(logName -> {
					//bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
					logRepository.save(new Log(logName));
				});
	}
}
