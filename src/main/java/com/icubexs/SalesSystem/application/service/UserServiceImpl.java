package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionDetService;
import com.icubexs.SalesSystem.application.port.in.UserService;
import com.icubexs.SalesSystem.application.port.out.CompanyRepository;
import com.icubexs.SalesSystem.application.port.out.PersonRepository;
import com.icubexs.SalesSystem.application.port.out.UserRepository;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PersonRepository personRepository; // Necesitarás este puerto
    private final CompanyRepository companyRepository; // Necesitarás este puerto
    private final ConfiguracionDetService configService; // Para buscar los IDs de los roles

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);

    }



    @Override
    @Transactional // Imprescindible para que si falla el rol, se borre el usuario
    public User registerFullUser(User domain, List<String> roles) {
        if (existsByEmail(domain.getEmail())) {
            throw new RuntimeException("El correo electrónico " + domain.getEmail() + " ya está registrado.");
        }

        System.out.println("Guardando Persona: ID=" + domain.getPerson().getIdentification() +
                ", Tel=" + domain.getPerson().getPhone());
        // 1. Guardar Persona primero (genera el ID de persona)
        Person savedPerson = personRepository.save(domain.getPerson());
        domain.setPerson(savedPerson);

        // 2. Si es Vendedor, guardar su Empresa
        if (domain.getCompany() != null) {
            Company savedCompany = companyRepository.save(domain.getCompany());
            domain.setCompany(savedCompany);
        }

        // 3. Guardar el Usuario vinculado a Persona y Empresa
        User savedUser = repository.save(domain);

        // 4. Asignar Roles (Solución al "no tengo assignRole")
        for (String roleCode : roles) {
            // Buscamos el ID del rol en tus eslabones de configuración
            var roleDetail = configService.findByCodigo(roleCode)
                    .orElseThrow(() -> new RuntimeException("Rol no configurado: " + roleCode));

            // Llamamos al repositorio para insertar en la tabla intermedia user_role
            repository.assignRole(savedUser.getId(), roleDetail.getId());
        }

        return savedUser;
    }
}