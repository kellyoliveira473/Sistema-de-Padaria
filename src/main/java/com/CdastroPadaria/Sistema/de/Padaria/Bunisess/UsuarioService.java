package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.UsuarioReposity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioReposity reposity;

    public UsuarioService(UsuarioReposity reposity) {
        this.reposity = reposity;
    }
    public void salvarUsuario(Usuario usuario){
        reposity.save(usuario);
    }
    public Usuario buscarPorCpf(String cpf){
        return reposity.findByCpf(cpf)
                .orElseThrow(()-> new RuntimeException("Cpf não encotrado"));
    }
    public void deletarPorCpf(String cpf){
        reposity.deleteBycpf(cpf);
    }
    public Usuario atualizarPorCpf(String cpf ,Usuario usuario){
        Usuario usuarioEntities =  reposity.findByCpf(cpf)
                .orElseThrow(()-> new RuntimeException("Usuario nao encontrado "));
        Usuario usuarioAtual = usuario.builder()
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntities.getNome())
                .telefone(usuario.getTelefone()!= null ? usuario.getTelefone(): usuarioEntities.getTelefone())
                .email(usuario.getEmail()!= null ? usuario.getEmail(): usuarioEntities.getEmail())
                .datanascimento(usuario.getDatanascimento()!= null ? usuario.getDatanascimento(): usuarioEntities.getDatanascimento())
                .cpf(usuarioEntities.getCpf())
                .build();
        return usuarioAtual;





}
    }
