package app;

import app.config.DatabaseLayerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"app.*"})
public class WebApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
	}

}
