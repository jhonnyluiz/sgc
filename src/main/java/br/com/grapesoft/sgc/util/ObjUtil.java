package br.com.grapesoft.sgc.util;

import java.util.Collection;

import org.springframework.util.ObjectUtils;

public class ObjUtil {

	private ObjUtil() {
	}

	/**
	 * Verifica se o objeto é igual a Nulo.
	 * 
	 * @param obj
	 * @return {@link Boolean}
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * Verificar se o objeto não é nulo.
	 * 
	 * @param obj
	 * @return {@link Boolean}
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * Verifica se o objeto não é vazio.
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String) {
			return ((String) obj).isEmpty();
		}
		if (obj instanceof Collection<?>) {
			return ((Collection<?>) obj).isEmpty();
		}
		return ObjectUtils.isEmpty(obj);
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
