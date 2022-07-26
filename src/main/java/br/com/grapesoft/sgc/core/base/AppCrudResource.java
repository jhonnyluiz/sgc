package br.com.grapesoft.sgc.core.base;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.grapesoft.sgc.core.constant.PathResource;

public abstract class AppCrudResource<S extends AppCrudService<R, T, ID>, R extends JpaRepository<T, ID>, DTO extends AppDTO, T extends AppEntity<ID>, ID>
		extends AppReadResource<S, R, T, ID> {

	@PostMapping
	public ResponseEntity<T> objectCreate(@Valid @RequestBody DTO dto) {
		T entity = modelMapper.map(dto, entityClass);
		return ResponseEntity.ok(getService().create(entity));
	}

	@PutMapping(PathResource.ID)
	public ResponseEntity<T> objectUpdate(@PathVariable ID id, @Valid @RequestBody DTO dto) {
		T entity = modelMapper.map(dto, entityClass);
		return ResponseEntity.ok(getService().update(id, entity));
	}

	@DeleteMapping(PathResource.ID)
	public ResponseEntity<Void> objectDelete(@PathVariable ID id) {
		getService().delete(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(PathResource.ALL)
	public ResponseEntity<Void> objectDeleteAll(@RequestParam List<ID> ids) {
		getService().deleteAll(ids);
		return ResponseEntity.ok().build();
	}

}
