package com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private boolean enabled = true;

    public User(String username, String password, UserRole role) {

        this.username = username;
        this.password = password;
        this.role = role;
    }
    @Override
    public Collection<? extends  GrantedAuthority>getAuthorities(){
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return enabled;
    }
}
