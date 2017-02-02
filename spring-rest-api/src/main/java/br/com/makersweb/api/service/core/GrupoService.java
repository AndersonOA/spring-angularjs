/**
 * 
 */
package br.com.makersweb.api.service.core;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.makersweb.api.domain.Grupo;
import br.com.makersweb.api.message.MakersMessage;
import br.com.makersweb.api.repository.IGrupoRepository;
import br.com.makersweb.api.service.IGrupoService;
import br.com.makersweb.api.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Service
@EnableTransactionManagement
public class GrupoService implements IGrupoService {
	
	private static final Logger _logger = LogManager.getLogger(GrupoService.class);
	
	@Autowired
	private IGrupoRepository grupoRepository;
	
	@Autowired
	private MessageSource messageSource;

	
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Grupo> listar() throws BusinessException {
		_logger.info("Iniciou método listar grupo...");
		
		List<Grupo> grupos = grupoRepository.findAll();
		
		if (CollectionUtils.isEmpty(grupos)) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.api.text.nao.encontrado", "Grupo"));
		}
		
		return grupos;
	}

}
