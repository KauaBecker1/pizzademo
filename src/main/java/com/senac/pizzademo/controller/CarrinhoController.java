package com.senac.pizzademo.controller;


import com.senac.pizzademo.repository.CarrinhoRepository;
import com.senac.pizzademo.model.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    // Listar todos os itens do carrinho
    @GetMapping
    public List<Carrinho> listarItens() {
        return carrinhoRepository.findAll();
    }

    // Adicionar item ao carrinho
    @PostMapping
    public Carrinho adicionarItem(@RequestBody Carrinho item) {
        return carrinhoRepository.save(item);
    }

    // Deletar item por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItem(@PathVariable Long id) {
        if (carrinhoRepository.existsById(id)) {
            carrinhoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Esvaziar o carrinho
    @DeleteMapping
    public ResponseEntity<Void> esvaziarCarrinho() {
        carrinhoRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // Buscar item por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> buscarItem(@PathVariable Long id) {
        Optional<Carrinho> item = carrinhoRepository.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
