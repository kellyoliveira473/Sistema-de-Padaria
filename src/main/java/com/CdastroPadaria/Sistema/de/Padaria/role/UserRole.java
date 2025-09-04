package com.CdastroPadaria.Sistema.de.Padaria.role;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    ADMIN("adimin"),
    USER("user");
    private String role;
    UserRole(String role){
        this.role=role;
    }
    @JsonValue
    public String getRole(){
        return  role;
    }
    @JsonCreator
    public static UserRole fromValue(String value){
        for (UserRole role : UserRole.values()){
            if (role.role.equalsIgnoreCase(value)){
                return role;
            }
        }
        throw  new IllegalAccessException("Invalido role "+ value);
    }
}
