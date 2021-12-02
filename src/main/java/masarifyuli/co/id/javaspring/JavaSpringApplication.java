package masarifyuli.co.id.javaspring;

import masarifyuli.co.id.javaspring.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JavaSpringApplication.class);

		Util u = new Util();
		app.setDefaultProperties(u.properties());
		app.run(args);
	}

}
