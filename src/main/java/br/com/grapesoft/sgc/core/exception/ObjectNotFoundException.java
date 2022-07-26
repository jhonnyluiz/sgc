package br.com.grapesoft.sgc.core.exception;

import br.com.grapesoft.sgc.core.constant.MsgConstant;
import br.com.grapesoft.sgc.security.type.TypeMessageExceptionEnum;

public class ObjectNotFoundException extends BusinessException {
	private static final long serialVersionUID = -2960757890164313424L;

	public <ID> ObjectNotFoundException(ID id, Class<?> clazz) {
		super();
		String[] parametersMessageDevelop = { id.toString(), clazz.getSimpleName() };
		setTypeMessage(TypeMessageExceptionEnum.E);
		setCodeMessage(MsgConstant.MSG_004);
		setParametersMessage(parametersMessageDevelop);
	}
}
