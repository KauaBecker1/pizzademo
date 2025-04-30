package com.senac.pizzademo.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity


public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Ingrediente;
    private String Quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_id")
    @JsonBackReference
    private Pizza pizza;

    public Long getId() {
        return this.id;
    }

    public String getIngrediente() {
        return this.Ingrediente;
    }

    public void setIngrediente(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public String getQuantidade() {
        return this.Quantidade;
    }

    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    public Ingredientes(String Ingrediente, String Quantidade, Pizza pizza) {
        this.Ingrediente = Ingrediente;
        this.Quantidade = Quantidade;
        this.pizza = pizza;
    }
    
    public Ingredientes() {
    }

}
