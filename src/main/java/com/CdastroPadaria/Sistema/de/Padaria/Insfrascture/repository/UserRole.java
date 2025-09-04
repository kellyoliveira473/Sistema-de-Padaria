package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRole extends JpaRepository<User,Long> {
}
