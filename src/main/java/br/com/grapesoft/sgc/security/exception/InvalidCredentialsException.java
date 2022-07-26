package br.com.grapesoft.sgc.security.exception;

import br.com.grapesoft.sgc.core.exception.BusinessException;
import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;

public class InvalidCredentialsException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public InvalidCredentialsException() {
		super(TypeMessageExceptionEnum.E, "INVALID_CREDENTIALS", "Usuário ou senha incorretos", null, false);
	}
}
