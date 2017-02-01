/**
 * 
 */
package br.com.makersweb.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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

}
