package br.com.grapesoft.sgc.security.exception;

import br.com.grapesoft.sgc.core.exception.BusinessException;
import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;

public class TokenInvalidException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public TokenInvalidException() {
		super(TypeMessageExceptionEnum.E, "TOKEN_INVALID", "Autenticação inválida", null, false);
	}
}
