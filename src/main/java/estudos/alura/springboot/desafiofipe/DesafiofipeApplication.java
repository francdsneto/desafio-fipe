package estudos.alura.springboot.desafiofipe;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafiofipeApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafiofipeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
