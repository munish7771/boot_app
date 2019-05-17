package com.coda.DAL;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coda.Entity.RoleEntity;
import com.coda.Entity.RoleName;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{

	Optional<RoleEntity> findByName(RoleName roleName);
}
