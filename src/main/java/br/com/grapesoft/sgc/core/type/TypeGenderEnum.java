package br.com.grapesoft.sgc.core.type;

import br.com.grapesoft.sgc.core.exception.EnumInvalidException;
import br.com.grapesoft.sgc.util.ObjUtil;
import lombok.Getter;

@Getter
public enum TypeGenderEnum {

	M(1, "Masculino"), F(2, "Feminino"), I(3, "Indefinido");

	TypeGenderEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private Integer codigo;
	private String descricao;

	public static TypeGenderEnum toEnum(Integer codigo) {
		if (ObjUtil.isNotEmpty(codigo)) {
			for (TypeGenderEnum enumerated : TypeGenderEnum.values()) {
				if (enumerated.getCodigo().equals(codigo)) {
					return enumerated;
				}
			}
		}
		throw new EnumInvalidException(codigo, TypeGenderEnum.class.getSimpleName());
	}
}
