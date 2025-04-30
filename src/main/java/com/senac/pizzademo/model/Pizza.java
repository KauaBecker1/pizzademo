package com.senac.pizzademo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity


public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Sabor;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Ingredientes> ingredientes;

    @OneToMany(mappedBy = "pizza" ,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Cardapio> cardapio;
    
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSabor() {
        return this.Sabor;
    }

    public void setSabor(String Sabor) {
        this.Sabor = Sabor;
    }

    public Set<Ingredientes> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(Set<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<Cardapio> getCardapio() {
        return this.cardapio;
    }

    public void setCardapio(Set<Cardapio> cardapio) {
        this.cardapio = cardapio;
    }

    public Pizza(String Sabor, Set<Ingredientes> ingredientes, Set<Cardapio> cardapio) {
        this.Sabor = Sabor;
        this.ingredientes = ingredientes;
        this.cardapio = cardapio;
    }

    public Pizza(){
        
    }



}

