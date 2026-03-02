package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    void deleteById(Long id);
    //findByEmail es necesario para el login
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    //User domain, List<String> roles
    User registerFullUser(User domain, List<String> roles);
}