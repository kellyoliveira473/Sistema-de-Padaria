package com.CdastroPadaria.Sistema.de.Padaria.Controller;

import com.CdastroPadaria.Sistema.de.Padaria.Bunisess.UsuarioService;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Usuario;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Void>salvarUusario( @RequestBody Usuario usuario){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario>buscarUsuarioPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(usuarioService.buscarPorCpf(cpf));
    }
    @DeleteMapping
    public ResponseEntity<Void>deletarUsuarioPorCpf(@RequestParam String cpf){
        usuarioService.deletarPorCpf(cpf);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void>atualizarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok().build();
    }


}
