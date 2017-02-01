/**
 * 
 */
package br.com.makersweb.api.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;

import br.com.makersweb.api.domain.DefaultDomain;
import br.com.makersweb.api.util.ConstantesUtils;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class AspectDao {
	
	public Object doBasicDomainInformation(ProceedingJoinPoint pjp) throws Throwable {
		Object myEntity = pjp.getArgs()[0];
		if (myEntity instanceof DefaultDomain) {
			myEntity = setDefaultValues((DefaultDomain) myEntity);
		}
		Object retVal = pjp.proceed();
		return retVal;
	}

	private DefaultDomain setDefaultValues(DefaultDomain defaultDomain) {
		if (defaultDomain.getId() != null) {
			defaultDomain.setAtualizado(LocalDateTime.now());
			defaultDomain.setAtualizadoPor(this.getUser());
		} else {
			defaultDomain.setCriado(LocalDateTime.now());
			defaultDomain.setCriadoPor(this.getUser());
		}
		return defaultDomain;
	}

	private String getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email;
		if (!ObjectUtils.isEmpty(auth) && !auth.getName().equals(ConstantesUtils.USER_ANONYMOUS)) {
			email = auth.getName();
		} else {
			email = ConstantesUtils.EMAIL_DEFAULT;
		}
		return email;

	}

}
