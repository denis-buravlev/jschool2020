package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByName(String name);
}
