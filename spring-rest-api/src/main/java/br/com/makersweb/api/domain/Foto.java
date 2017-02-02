/**
 * 
 */
package br.com.makersweb.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Entity
@Table(name = "tb_foto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Foto extends DefaultDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1261582785433010081L;

	@Column(name = "titulo", nullable = false, length = 150)
	private String titulo;

	@Column(name = "url", nullable = false, length = 255)
	private String url;

	@Column(name = "descricao", length = 255)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
