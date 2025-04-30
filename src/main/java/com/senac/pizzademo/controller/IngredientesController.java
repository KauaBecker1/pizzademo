package com.senac.pizzademo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pizzademo.model.Ingredientes;
import com.senac.pizzademo.repository.IngredientesRepository;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @GetMapping
    public List<Ingredientes> getAllIngredientes() {
        return ingredientesRepository.findAll();
    }

    @PostMapping
    public Ingredientes createPizza(@RequestBody Ingredientes ingredientes) {
        return ingredientesRepository.save(ingredientes);
    }

    // Adicionar métodos para atualização e exclusão conforme necessário
}
