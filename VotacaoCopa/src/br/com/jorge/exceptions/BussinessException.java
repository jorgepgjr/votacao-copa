/**
 * 
 */
package br.com.jorge.exceptions;

/**
 *Exception padrão para erro de negocio.
 * @author Jorge
 * @since 27/11/2012
 */
public class BussinessException extends Exception {
	private static final long serialVersionUID = 4462820640918730638L;

	public BussinessException(String message) {
		super(message);
	}
}
