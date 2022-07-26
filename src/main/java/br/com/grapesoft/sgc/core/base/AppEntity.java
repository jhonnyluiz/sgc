package br.com.grapesoft.sgc.core.base;

import static br.com.grapesoft.sgc.util.ObjUtil.isEmpty;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AppEntity<ID> implements Serializable {
	private static final long serialVersionUID = -3250877196364766099L;

	public abstract void setId(ID id);

	public abstract ID getId();

	@JsonIgnore
	public final Boolean isTransient() {
		return isEmpty(getId());
	}
}
