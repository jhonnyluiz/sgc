package br.com.grapesoft.sgc.core.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AppCrudService<R extends JpaRepository<T, ID>, T extends AppEntity<ID>, ID>
		extends AppReadService<R, T, ID> {

	public T create(T entity) {
		entity.setId(null);
		return getRepo().save(toCreateValue(entity));
	}

	protected T toCreateValue(T entity) {
		return entity;
	}

	public T update(ID id, T entity) {
		T entityDB = findById(id);
		return getRepo().save(toUpdateValue(entity, entityDB));
	}

	public List<T> saveAll(List<T> entities) {
		return getRepo().saveAll(entities);
	}

	protected abstract T toUpdateValue(T entity, T entityDB);

	public void delete(ID id) {
		getRepo().deleteById(id);
	}

	public void deleteAll(List<ID> ids) {
		getRepo().deleteAllById(ids);
	}
}
