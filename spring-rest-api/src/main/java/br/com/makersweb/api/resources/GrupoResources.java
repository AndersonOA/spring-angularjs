/**
 * 
 */
package br.com.makersweb.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.api.service.IGrupoService;
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
public class GrupoResources {
	
	@Autowired
	private IGrupoService grupoService;
	
	@RequestMapping(value = "/grupo", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		DefaultResponse response = new DefaultResponse();
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(grupoService.listar());
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(ConstantesUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}

}
