/**
 * 
 */
package br.com.makersweb.api.service;

import java.util.List;

import br.com.makersweb.api.domain.Grupo;
import br.com.makersweb.api.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public interface IGrupoService {
	
	List<Grupo> listar() throws BusinessException;

}
