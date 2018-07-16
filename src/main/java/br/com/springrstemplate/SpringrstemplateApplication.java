package br.com.springrstemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringrstemplateApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringrstemplateApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(LogRepository logRepository) {
		return args ->
			Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
				.forEach(logName -> {
					//bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
					logRepository.save(new Log(logName));
				});
	}*/
}
