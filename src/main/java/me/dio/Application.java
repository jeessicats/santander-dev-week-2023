package me.dio;

// Importa as classes necessárias para a configuração do Spring Boot e OpenAPI
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Define a configuração OpenAPI para a aplicação
// @OpenAPIDefinition configura a URL e a descrição do servidor para a documentação OpenAPI
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
// Define a classe como uma aplicação Spring Boot
@SpringBootApplication
public class Application {

	// Método principal que inicia a aplicação Spring Boot
	public static void main(String[] args) {
		// Executa a aplicação Spring Boot
		SpringApplication.run(Application.class, args);
	}

}
