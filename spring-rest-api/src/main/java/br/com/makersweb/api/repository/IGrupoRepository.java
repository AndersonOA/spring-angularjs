/**
 * 
 */
package br.com.makersweb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.api.domain.Grupo;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IGrupoRepository extends JpaRepository<Grupo, Long> {

}
