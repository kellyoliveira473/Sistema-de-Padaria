package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
