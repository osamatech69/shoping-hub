package com.shopme.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopme.coomon.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
