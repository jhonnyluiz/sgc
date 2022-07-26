package br.com.grapesoft.sgc.core.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.grapesoft.sgc.security.persistence.entity.OperacaoSistema;
import br.com.grapesoft.sgc.security.persistence.entity.Role;

public class RoleConstant {
	private RoleConstant() {
	}

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String OP_USUARIO_CREATE = "OP_USUARIO_CREATE";
	public static final List<String> operationsAdmin = Arrays.asList(OP_USUARIO_CREATE);

	public static final String ROLE_MANAGER = "ROLE_MANAGER";
	public static final String OP_USUARIO_DELETE = "OP_USUARIO_DELETE";
	public static final List<String> operationsManager = Arrays.asList(OP_USUARIO_DELETE);

	public static final String ROLE_EDITOR = "ROLE_EDITOR";
	public static final String OP_USUARIO_UPDATE = "OP_USUARIO_UPDATE";
	public static final List<String> operationsEditor = Arrays.asList(OP_USUARIO_UPDATE);

	public static final String ROLE_CLIENT = "ROLE_CLIENT";
	public static final String OP_USUARIO_READ = "OP_USUARIO_READ";
	public static final List<String> operationsClient = Arrays.asList(OP_USUARIO_READ);

	private static Map<String, List<String>> getOperations() {
		Map<String, List<String>> operations = new HashMap<>();
		operations.put(ROLE_ADMIN, operationsAdmin);
		operations.put(ROLE_MANAGER, operationsManager);
		operations.put(ROLE_EDITOR, operationsEditor);
		operations.put(ROLE_CLIENT, operationsClient);
		return operations;
	}

	public static List<String> getStrRoles() {
		return Arrays.asList(ROLE_ADMIN, ROLE_MANAGER, ROLE_EDITOR, ROLE_CLIENT);
	}

	public static List<Role> getRoles() {
		return getStrRoles().stream()
				.map(r -> Role.builder().id(r)
						.allowedOperations(getOperations().get(r).stream()
								.map(op -> OperacaoSistema.builder().id(op).build()).collect(Collectors.toList()))
						.build())
				.collect(Collectors.toList());
	}
}
