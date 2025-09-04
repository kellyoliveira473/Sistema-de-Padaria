package com.CdastroPadaria.Sistema.de.Padaria.Controller;

import com.CdastroPadaria.Sistema.de.Padaria.Bunisess.PadariaService;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/padaria")
public class PadariaController {
    private final PadariaService padariaService;
    private PadariaService service;

    public PadariaController(PadariaService padariaService) {
        this.padariaService = padariaService;
    }

    @PostMapping
    public ResponseEntity<Void>CadastrarProduto(@RequestBody Padaria padaria){
        padariaService.CadastrProduto(padaria);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Padaria>BuscarProdutoPorId(@RequestParam Long id){
      return ResponseEntity.ok(padariaService.BuscaPadariaPorId(id));

    }
    @DeleteMapping
    public ResponseEntity<Void>ExcluirProduto(@RequestParam Long id){
        padariaService.deletarProdutoPorId(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void>AtualizarProduto(@RequestParam Long id, @RequestBody Padaria padaria){
        padariaService.AtualizaProdutoPorid(id, padaria);
        return ResponseEntity.ok().build();
    }
}
