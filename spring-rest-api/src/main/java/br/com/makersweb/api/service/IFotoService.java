/**
 * 
 */
package br.com.makersweb.api.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import br.com.makersweb.api.domain.Foto;
import br.com.makersweb.api.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IFotoService {

	List<Foto> listar() throws BusinessException;

	Foto buscar(Long id) throws BusinessException;

	Foto salvar(Foto foto) throws BusinessException;

	Foto atualizar(Foto foto) throws BusinessException;

	void deletar(Long id) throws EmptyResultDataAccessException;

	void verificaExistencia(Foto foto) throws BusinessException;

}
