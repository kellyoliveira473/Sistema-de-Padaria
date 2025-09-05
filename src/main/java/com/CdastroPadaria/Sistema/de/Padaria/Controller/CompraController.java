package com.CdastroPadaria.Sistema.de.Padaria.Controller;

import com.CdastroPadaria.Sistema.de.Padaria.Bunisess.CompraService;
import com.CdastroPadaria.Sistema.de.Padaria.DTO.CompraDTO;
import com.CdastroPadaria.Sistema.de.Padaria.DTO.RegisterDto;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Compra;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/compas")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }
    @PostMapping
    public ResponseEntity<Compra > CriarCompra(@RequestBody CompraDTO dto) {
        Compra novaCompra=compraService.criarCompraComDTO(dto);
        return ResponseEntity.ok(novaCompra);
    }
}
