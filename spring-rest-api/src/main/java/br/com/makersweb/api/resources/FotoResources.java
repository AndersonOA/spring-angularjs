/**
 * 
 */
package br.com.makersweb.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.api.domain.Foto;
import br.com.makersweb.api.service.IFotoService;
import br.com.makersweb.api.service.exception.BusinessException;
import br.com.makersweb.api.util.ConstantesUtils;
import br.com.makersweb.api.util.DefaultResponse;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@RestController
@RequestMapping("${makersweb.api}")
public class FotoResources {

	@Autowired
	private IFotoService fotoService;

	@RequestMapping(value = "/foto", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		DefaultResponse response = new DefaultResponse();

		try {
			return ResponseEntity.status(HttpStatus.OK).body(fotoService.listar());
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/foto/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();

		try {
			return ResponseEntity.status(HttpStatus.OK).body(fotoService.buscar(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/foto", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Foto foto) {
		DefaultResponse response = new DefaultResponse();

		try {
			Foto myFoto = fotoService.salvar(foto);
			
			response.setId(myFoto.getId());
			response.setError(false);
			response.setTypeError(ConstantesUtils.E_USER_SUCESS);
			response.setMessage("Foto cadastrada com sucesso!");
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/foto/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody Foto foto) {
		DefaultResponse response = new DefaultResponse();

		try {
			foto.setId(id);
			Foto myFoto = fotoService.atualizar(foto);
			
			response.setId(myFoto.getId());
			response.setError(false);
			response.setTypeError(ConstantesUtils.E_USER_SUCESS);
			response.setMessage("Foto atualizada com sucesso!");
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/foto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();

		try {
			fotoService.deletar(id);

			response.setError(false);
			response.setTypeError(ConstantesUtils.E_USER_SUCESS);
			response.setMessage("Foto deletada com sucesso!");
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

}
