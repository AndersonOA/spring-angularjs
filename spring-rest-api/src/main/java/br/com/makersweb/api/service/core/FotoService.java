/**
 * 
 */
package br.com.makersweb.api.service.core;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import br.com.makersweb.api.domain.Foto;
import br.com.makersweb.api.message.MakersMessage;
import br.com.makersweb.api.repository.IFotoRepository;
import br.com.makersweb.api.service.IFotoService;
import br.com.makersweb.api.service.exception.BusinessException;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Service
@EnableTransactionManagement
public class FotoService implements IFotoService {

	private static final Logger _logger = LogManager.getLogger(FotoService.class);

	@Autowired
	private IFotoRepository fotoRepository;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Foto> listar() throws BusinessException {
		_logger.info("Iniciou método listar foto...");

		List<Foto> fotos = fotoRepository.findAll();

		if (CollectionUtils.isEmpty(fotos)) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.api.text.nao.encontrado", "Foto"));
		}

		return fotos;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Foto buscar(Long id) throws BusinessException {
		_logger.info("Iniciou método buscar foto...");

		Foto foto = fotoRepository.findOne(id);

		if (ObjectUtils.isEmpty(foto)) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.api.text.nao.encontrado", "Foto"));
		}

		return foto;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Foto salvar(Foto foto) throws BusinessException {
		_logger.info("Iniciou método salvar foto...");

		if (ObjectUtils.isEmpty(foto)) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.api.text.campos.obrigatorio"));
		}

		return fotoRepository.save(foto);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Foto atualizar(Foto foto) throws BusinessException {
		_logger.info("Iniciou método atualizar foto...");
		verificaExistencia(foto);

		return fotoRepository.save(foto);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void deletar(Long id) throws EmptyResultDataAccessException {
		_logger.info("Iniciou método deletar foto...");

		try {
			fotoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new BusinessException(
					new MakersMessage(messageSource).message("br.com.makersweb.api.text.nao.encontrado", "Foto"));
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void verificaExistencia(Foto foto) throws BusinessException {
		_logger.info("Iniciou método verificaExistencia foto...");
		buscar(foto.getId());
	}

}
