package com.icubexs.SalesSystem.application.service;
import com.icubexs.SalesSystem.application.port.in.UserRoleService;
import com.icubexs.SalesSystem.application.port.out.UserRoleRepository;
import com.icubexs.SalesSystem.domain.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repository;

    @Override
    public UserRole save(UserRole userRole) {
        // Podrías validar aquí que el status no sea nulo por defecto
        if (userRole.getStatus() == null) userRole.setStatus(true);
        return repository.save(userRole);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}