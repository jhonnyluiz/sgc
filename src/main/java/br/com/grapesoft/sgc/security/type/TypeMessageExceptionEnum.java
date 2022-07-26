package br.com.grapesoft.sgc.security.type;

import br.com.grapesoft.sgc.core.exception.EnumInvalidException;
import br.com.grapesoft.sgc.util.ObjUtil;

public enum TypeMessageExceptionEnum {

	E(1, "Erro!"), A(2, "Atenção!"), I(3, "Informação!");

	TypeMessageExceptionEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private Integer codigo;
	private String descricao;

	public TypeMessageExceptionEnum toEnum(Integer codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (TypeMessageExceptionEnum enumerated : TypeMessageExceptionEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, TypeMessageExceptionEnum.class.getSimpleName());
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
}
