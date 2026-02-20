package com.icubexs.SalesSystem.application.port.out;


import com.icubexs.SalesSystem.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    boolean existsByUsername(String username);

}
