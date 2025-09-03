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

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Void>salvarUusario( @RequestBody Usuario usuario){
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Usuario>>listarTodos(){
        return ResponseEntity.ok().build();
    }

}
