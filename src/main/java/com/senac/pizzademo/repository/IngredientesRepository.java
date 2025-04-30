
package com.senac.pizzademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.pizzademo.model.Ingredientes;

public interface IngredientesRepository extends JpaRepository<Ingredientes, Long> {
}
