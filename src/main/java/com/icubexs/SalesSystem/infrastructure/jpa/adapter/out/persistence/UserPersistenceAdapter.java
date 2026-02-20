package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.application.port.out.UserRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setCompanyId(user.getCompanyId());

        UserEntity saved = userJpaRepository.save(entity);
        return new User(saved.getUserId(), saved.getUsername(),
                saved.getPassword(), saved.getEmail(), saved.getCompanyId());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(e -> new User(e.getUserId(), e.getUsername(),
                        e.getPassword(), e.getEmail(), e.getCompanyId()));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userJpaRepository.existsByUsername(username);

    }

}
