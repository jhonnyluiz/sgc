package br.com.grapesoft.sgc.security.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grapesoft.sgc.security.persistence.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
