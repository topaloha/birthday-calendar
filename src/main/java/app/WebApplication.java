package app;

import app.config.DatabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@SpringBootApplication
@Import(DatabaseConfig.class)
public class WebApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
	}

}
