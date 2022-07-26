package br.com.grapesoft.sgc.core.type;

import br.com.grapesoft.sgc.core.exception.EnumInvalidException;
import br.com.grapesoft.sgc.util.ObjUtil;
import lombok.Getter;

@Getter
public enum SimNaoEnum {

	SIM(1, "Sim"), NAO(2, "Não");

	SimNaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private Integer codigo;
	private String descricao;

	public static SimNaoEnum toEnum(Integer codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (SimNaoEnum enumerated : SimNaoEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, SimNaoEnum.class.getSimpleName());
	}
}
