package com.icubexs.SalesSystem.application.port.out;


import com.icubexs.SalesSystem.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findAll();
    void deleteById(Long id);
    void assignRole(Long userId, Long roleId);

}
