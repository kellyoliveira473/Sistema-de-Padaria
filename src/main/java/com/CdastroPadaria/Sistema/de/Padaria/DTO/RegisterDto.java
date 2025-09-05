package com.CdastroPadaria.Sistema.de.Padaria.DTO;

import com.CdastroPadaria.Sistema.de.Padaria.role.UserRole;

public record RegisterDto (
        String login,
        String password,
        UserRole role
){}
