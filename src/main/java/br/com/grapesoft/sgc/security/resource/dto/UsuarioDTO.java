package br.com.grapesoft.sgc.security.resource.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.grapesoft.sgc.core.base.AppDTO;
import br.com.grapesoft.sgc.core.type.SimNaoEnum;
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
public class UsuarioDTO extends AppDTO {
	private static final long serialVersionUID = -5914665872791692641L;
	
	private Long id;
	private String username;
	private Long pessoaId;
	private LocalDate dataExpiracaoConta;
	private LocalDate dataExpiracaoCredencial;
	private SimNaoEnum contaAtiva;
	private SimNaoEnum contaBloqueada;
	private List<RoleDTO> roles;
}
