package com.senac.pizzademo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pizzademo.model.Cardapio;
import com.senac.pizzademo.repository.CardapioRepository;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private CardapioRepository cardapioRepository;

    @GetMapping
    public List<Cardapio> getAllCardapios() {
        return cardapioRepository.findAll();
    }

    @PostMapping
    public Cardapio createCardapio(@RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    // Adicionar métodos para atualização e exclusão conforme necessário
}
