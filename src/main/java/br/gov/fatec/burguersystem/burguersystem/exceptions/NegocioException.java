package br.gov.fatec.burguersystem.burguersystem.exceptions;

public class NegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8092741493631346307L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}

}
