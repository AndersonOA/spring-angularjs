/**
 * 
 */
package br.com.makersweb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.api.domain.Foto;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IFotoRepository extends JpaRepository<Foto, Long> {

}
