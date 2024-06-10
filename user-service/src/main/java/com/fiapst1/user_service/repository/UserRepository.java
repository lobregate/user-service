package com.fiapst1.user_service.repository;

import com.fiapst1.user_service.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
