/**
 * 
 */
package br.com.makersweb.api.service.exception;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -622135605731915190L;

	/**
	 * 
	 */
	public BusinessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * @param message
	 */
	public BusinessException(String message, Boolean error, String typeError) {
		super(message);
	}

}
