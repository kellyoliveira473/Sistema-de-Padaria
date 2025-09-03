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
        if(usuario.getNome() !=null){
            usuarioEntities.setNome(usuario.getNome());
        }
        if(usuario.getCpf()!= null){
            usuarioEntities.setCpf(usuario.getNome());
        }
        if(usuario.getEmail()!=null){
            usuarioEntities.setEmail(usuario.getEmail());
        }
        if(usuario.getDatanascimento()!= null){
            usuarioEntities.setDatanascimento(usuario.getDatanascimento());
        }
        if(usuario.getTelefone()!=null){
            usuarioEntities.setTelefone(usuario.getTelefone());
        }
        return reposity.save(usuarioEntities);

    }
        public List<Usuario>ListarTodos(){
        return reposity.findAll();
        }
}
