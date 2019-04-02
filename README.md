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

Crie duas classes, uma será nosso request e outra para expor nossos endpoints.

PessoaDTO.java

```
@ApiModel(value = "Pessoa")
public class PessoaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id da pessoa.", required = false)
	private Integer id;

	@ApiModelProperty(value = "Nome da pessoa.", required = true)
	private String nome;

	@ApiModelProperty(value = "Sobrenome da pessoa.", required = true)
	private String sobreNome;

	@ApiModelProperty(value = "Idade da pessoa.", required = true)
	private Integer idade;

	@ApiModelProperty(value = "Tamanho da pessoa.", required = false)
	private Double tamanho;

	@ApiModelProperty(value = "Peso da pessoa.", required = false)
	private Double peso;
	
}
```

@ApiModel: Serve para nomear a classe do modelo.

@ApiModelProperty: Descrever uma propriedade dentro da classe modelo.


Controller

```
@Api(value="Pessoa API")
@RestController
@RequestMapping("v1/api")
public class APISwaggerController {
	
	@ApiOperation(value="Consulta todas as pessoas do sistema", notes="Consulta síncrona.")
	@GetMapping
    public ResponseEntity pessoas() {
        return ResponseEntity.status(HttpStatus.OK).body("Consulta de pessoas executada com sucesso!");
    }
	
	@ApiOperation(value="Consulta o cliente por id existente no sistema", notes="Consulta síncrona.")
    @GetMapping("/pessoas/{id}")
    public ResponseEntity consultarPessoaPorId(@ApiParam(value="Id da pessoa") @PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body("Consulta executada com sucesso! Id=" + id);
    }
	
	@ApiOperation(value="Cria uma pessoa no sistema", notes="Consulta síncrona.")
    @PostMapping
    public ResponseEntity criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa inserido com sucesso!");
    }
    
	@ApiOperation(value="Deleta uma pessoa por id do sistema", notes="Consulta síncrona.")
    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity deletarPessoa(@ApiParam(value="Id da pessoa") @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }
    
	@ApiOperation(value="Atualiza uma pessoa do sistema", notes="Consulta síncrona.")
    @PutMapping
    public ResponseEntity deletarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }

}
```

@Api: Utilizada para anotar a classe que cria uma API Rest

@ApiOperation: Descreve uma operação ou um recurso HTTP

@ApiParam: Representa um parâmetro de entrada em uma operação/recurso HTTP

Feito isso, subimos nossa aplicação. A documentação fica disponivel no contexto /swaggwe-ui.html, no nosso caso: http://localhost:8081/documentacao/swagger-ui.html.

![swagger](https://user-images.githubusercontent.com/6553978/55373081-696f0d00-54da-11e9-8aaa-50e01282f1f6.png)


![swagger2](https://user-images.githubusercontent.com/6553978/55373106-84da1800-54da-11e9-9dba-e4a58775725a.png)







