/**
 * 
 */
package br.com.makersweb.api.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Entity
@Table(name = "tb_grupo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Grupo extends DefaultDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6874523122367302814L;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "grupo")
	private Set<Foto> foto;

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
	 * @return the foto
	 */
	public Set<Foto> getFoto() {
		return foto;
	}

	/**
	 * @param foto
	 *            the foto to set
	 */
	public void setFoto(Set<Foto> foto) {
		this.foto = foto;
	}

}
