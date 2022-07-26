package br.com.grapesoft.sgc.security.resource.dto;

import java.util.List;

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
@EqualsAndHashCode(callSuper = false)
public class RoleDTO extends AppDTO {
	private static final long serialVersionUID = 5236156701227149759L;

	private String id;
	private List<OperacaoSistemaDTO> allowedOperations;
}
