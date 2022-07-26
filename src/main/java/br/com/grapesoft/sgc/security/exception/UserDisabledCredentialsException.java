package br.com.grapesoft.sgc.security.exception;

import br.com.grapesoft.sgc.core.exception.BusinessException;
import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;

public class UserDisabledCredentialsException extends BusinessException {
	private static final long serialVersionUID = 7975080165777150128L;

	public UserDisabledCredentialsException() {
		super(TypeMessageExceptionEnum.E, "USER_DISABLED", "Usuário desabilitado", null, false);
	}
}
