package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UserRepository;
import com.CdastroPadaria.Sistema.de.Padaria.role.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean userExists(String login) {
        return repository.findByUsername(login) != null; // corrigido "finByUsername"
    }

    public void registerUser(String login, String password, String roleStr) {
        if (userExists(login)) { // lógica invertida: só lança exceção se já existir
            throw new RuntimeException("Usuário já existe!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(password); // corrigido "encade"
        UserRole roleEnum;
        try {
            roleEnum = UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role inválida: " + roleStr);
        }
        User newUser = new User(login, encryptedPassword, roleEnum);
        repository.save(newUser);
    }

    public User findByLogin(String login) {
        return repository.findByUsername(login);
    }
}
