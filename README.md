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
