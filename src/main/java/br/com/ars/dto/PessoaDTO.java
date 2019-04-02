package br.com.ars.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobreNome
	 */
	public String getSobreNome() {
		return sobreNome;
	}

	/**
	 * @param sobreNome
	 *            the sobreNome to set
	 */
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**
	 * @return the tamanho
	 */
	public Double getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho
	 *            the tamanho to set
	 */
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PessoaDTO [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", idade=" + idade + ", tamanho="
				+ tamanho + ", peso=" + peso + "]";
	}

}
