package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioReposity extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByCpf(String cpf);
    @Transactional
    void deleteBycpf(String cpf);
}
