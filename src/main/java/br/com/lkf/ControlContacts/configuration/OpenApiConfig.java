package br.com.lkf.ControlContacts.configuration;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
 
@Configuration
public class OpenApiConfig {
 
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(
						new Info()
							.title("Avaliação Java / Spring: API Rest para Controle de Contatos")
							.description("O desafio consiste em criar uma aplicação API Rest para gerenciar um sistema de\r\n"
									+ "cadastro de Pessoas e seus respectivos Contatos, onde cada Pessoa pode ter vários Contatos. O\r\n"
									+ "principal objetivo é permitir que operações CRUD (Criar, Ler, Atualizar, Deletar) sejam realizadas\r\n"
									+ "na estrutura de Pessoas e Contatos.")
							.contact(new Contact()
										.name("Lucas Kirow Fernandes")
										.email("lucasfernandesf18@gmail.com")
										.url("http://localhost:8080")
									)
							.version("Versão 0.0.1-SNAPSHOT")
						);
	}
	
}
 			