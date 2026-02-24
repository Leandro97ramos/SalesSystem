package com.icubexs.SalesSystem.application.service;


import com.icubexs.SalesSystem.application.port.in.UserPermissionService;
import com.icubexs.SalesSystem.application.port.out.UserPermissionRepository;
import com.icubexs.SalesSystem.domain.model.UserPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPermissionServiceImpl implements UserPermissionService {

    private final UserPermissionRepository repository;

    @Override
    public UserPermission save(UserPermission permission) {
        return repository.save(permission);
    }

    @Override
    public Optional<UserPermission> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<UserPermission> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}