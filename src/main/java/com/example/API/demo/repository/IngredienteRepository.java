package com.example.API.demo.repository;

import com.example.API.demo.DTO.IngredienteDTO;

public interface IngredienteRepository {
    public IngredienteDTO findIngredienteByName(String nomeIngrediente);
}
