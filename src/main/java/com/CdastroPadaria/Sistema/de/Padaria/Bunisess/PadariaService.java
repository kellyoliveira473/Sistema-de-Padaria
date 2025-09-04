package com.CdastroPadaria.Sistema.de.Padaria.Bunisess;

import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.entitys.Padaria;
import com.CdastroPadaria.Sistema.de.Padaria.Insfrascture.repository.PadariaRepository;
import org.springframework.stereotype.Service;

@Service

public class PadariaService {
    private final PadariaRepository repository;

    public PadariaService(PadariaRepository repository) {
        this.repository = repository;
    }
    public void  CadastrProduto(Padaria padaria){
        repository.saveAndFlush(padaria);

    }
    public Padaria BuscaPadariaPorId(Long id){
        return repository.findById(id).orElseThrow(
                ()->new RuntimeException("Produto nao encontrado ")
        );
    }
    public void  deletarProdutoPorId(Long id){
        repository.deleteById(id);

    }
    public void AtualizaProdutoPorid(Long id, Padaria padaria){
        Padaria produtoEntity = repository.findById(id).orElseThrow(
                ()->new RuntimeException("Produto nao encontrado ")
        );
        Padaria produtoAtualizado = padaria.builder()
                .id(padaria.getId()!=null ? padaria.getId() :
                        produtoEntity.getId())
                .produtos(padaria.getProdutos()!=null ? padaria.getProdutos():
                        produtoEntity.getProdutos())
                .valor(padaria.getValor()!= null ? padaria.getValor():
                        produtoEntity.getValor())
                .build();
        repository.saveAndFlush(produtoAtualizado);

    }

}
