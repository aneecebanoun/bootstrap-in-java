package bootstrap.in.java;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

@SpringBootApplication
public class BootstrapInJava {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapInJava.class, args);
	}

	@Bean
	public Configuration getFtlConfiguration() throws IOException, URISyntaxException {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
		configuration.setClassForTemplateLoading(this.getClass(), "/ftls");
		configuration.setDefaultEncoding("UTF-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		return configuration;
	}
}
