package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Role findByName(String name);
}
