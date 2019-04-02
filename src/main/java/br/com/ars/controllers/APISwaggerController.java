package br.com.ars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ars.dto.PessoaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Pessoa API")
@RestController("v1/api")
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
