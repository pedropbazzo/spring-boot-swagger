# Documentando API Rest com Swagger

Swagger é uma ferramenta para criação de documentação de API's Rest de forma padronizada que facilita ao entendimento de cada serviço existente em uma estrutura de API sem a necessidade de abrir o código fonte para saber seu funcionamento. Com Swagger configurado, e possivel relizar testes rápidos de seus endpoints.

# Configuração

Para configurar o Swagger em seu projeto, basta seguir os passos abaixo. Com poucas linhas de código e possivel documentar suas API's.

A partir de um projeto SpringBoot, adicione as dependencias abaixo:

```
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```
Crie um classe com o nome de SwaggerConfig. Ela e responsavel por habilitar o Swagger em nosso projeto, alem de conter as principais informações do projeto.

```
@Configuration
@EnableSwagger2
@ComponentScan("br.com.ars.controllers")
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	/**
	 * Metode informação da API
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("API de funcionalidades de pessoa", "Descrição da API de funcionalidades de pessoa.", "API Pessoa",
				"Termos de Serviço", new Contact("Adilson Silva", "www.ars.com.br", "adilson.ro.silva@gmail.com.br"),
				"Licença da API", "Lincença da API URL", Collections.emptyList());
	}

}
```
@Configurarion, responsavel por avisar ao Spring que esta classe e um novo Bean. 

@EnableSwagger2, habilita o Swagger no nosso projeto.

@ComponentScan, informa onde se encontra as classes que seram utilizadas para criação da documentação.

@Bean, Indica que o metódo anotado deve ser gerenciado pelo Spring.

api() Cria a documentação

apiInfo() Contem as informaçes da API, como descrição, criador e seus dados para contato, dadps de licença, etc..



