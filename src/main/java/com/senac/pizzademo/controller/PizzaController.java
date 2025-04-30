package com.senac.pizzademo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pizzademo.model.Ingredientes;
import com.senac.pizzademo.repository.IngredientesRepository;
import com.senac.pizzademo.repository.CarrinhoRepository;
import com.senac.pizzademo.model.Pizza;
import com.senac.pizzademo.repository.PizzaRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;
    private IngredientesRepository ingredientesRepository;
    private CarrinhoRepository carrinhoRepository;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody Pizza updatePizza){

        System.out.println("Put recebido para pizza id"+id);



        return pizzaRepository.findById(id).map(pizza ->{
            pizza.setSabor(updatePizza.getSabor());

            if(updatePizza.getIngredientes() != null){
                pizza.getIngredientes().clear();
                updatePizza.getIngredientes().forEach(i ->i.setPizza(pizza));
                pizza.getIngredientes().addAll(updatePizza.getIngredientes());
            }
           
            if(updatePizza.getCardapio() != null){
                pizza.getCardapio().clear();
                updatePizza.getCardapio().forEach(i ->i.setPizza(pizza));
                pizza.getCardapio().addAll(updatePizza.getCardapio());

            }

            Pizza saved = pizzaRepository.save(pizza);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }


     @DeleteMapping("/carrinho/{id}")
public ResponseEntity<Void> deletarCarrinho(@PathVariable Long id) {
    carrinhoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
}

 
 
 
    
    // Adicionar métodos para atualização e exclusão conforme necessário
}
