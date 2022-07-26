package br.com.grapesoft.sgc.security.exception;

import br.com.grapesoft.sgc.core.exception.BusinessException;
import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;

public class TokenExpiredException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public TokenExpiredException() {
		super(TypeMessageExceptionEnum.E, "TOKEN_EXPIRED", "Autenticação expirada", null, false);
	}
}
