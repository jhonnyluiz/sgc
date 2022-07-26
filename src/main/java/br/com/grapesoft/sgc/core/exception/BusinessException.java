package br.com.grapesoft.sgc.core.exception;

import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 7139506938542051826L;

	private TypeMessageExceptionEnum typeMessage;
	private String codeMessage;
	private String message;
	private Object[] parametersMessage;
	private Boolean developError;

	public BusinessException(String codeMessage, Object[] parametersMessage) {
		setCodeMessage(codeMessage);
		setParametersMessage(parametersMessage);
	}
}
