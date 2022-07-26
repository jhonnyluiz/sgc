package br.com.grapesoft.sgc.security.resource.dto;

import br.com.grapesoft.sgc.core.base.AppDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class OperacaoSistemaDTO extends AppDTO {
	private static final long serialVersionUID = -8377323819738654555L;

	@EqualsAndHashCode.Include
	private String id;
}
