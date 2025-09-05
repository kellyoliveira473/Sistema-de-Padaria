package com.CdastroPadaria.Sistema.de.Padaria.Controller;

import com.CdastroPadaria.Sistema.de.Padaria.DTO.RegisterDto;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AutenticationController {

    private final UserRepository repository;

    public AutenticationController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto data) {
        if (this.repository.findByUsername(data.login()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password()); // corrigido "encade"
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.repository.save(newUser);
        return ResponseEntity.ok().body("Usuário registrado com sucesso!");
    }
}
