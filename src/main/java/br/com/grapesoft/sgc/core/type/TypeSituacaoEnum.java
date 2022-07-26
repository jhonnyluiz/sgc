package br.com.grapesoft.sgc.core.type;

import br.com.grapesoft.sgc.core.exception.EnumInvalidException;
import br.com.grapesoft.sgc.util.ObjUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeSituacaoEnum {

	ATIVO("ATIVO", "Ativo"), INATIVO("INATIVO", "Inativo");

	private String codigo;
	private String descricao;

	public static TypeSituacaoEnum toEnum(String codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (TypeSituacaoEnum enumerated : TypeSituacaoEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, TypeSituacaoEnum.class.getSimpleName());
	}
}
