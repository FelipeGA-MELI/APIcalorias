package com.example.API.demo.repository;

import com.example.API.demo.DTO.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository{
    @Override
    public IngredienteDTO findIngredienteByName(String nomeIngrediente) {
        List<IngredienteDTO> ingredienteDTOS;
        ingredienteDTOS = LocalDataBase();
        IngredienteDTO resultado = null;

        if(ingredienteDTOS != null) {
            Optional<IngredienteDTO> ingrediente = ingredienteDTOS.stream()
                    .filter(ingredienteDTO -> ingredienteDTO.getNome().equals(nomeIngrediente))
                    .findFirst();
            if(ingrediente.isPresent())
                resultado = ingrediente.get();
        }

        return resultado;
    }

    private List<IngredienteDTO> LocalDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("/Users/fgusmao/Downloads/APIcalorias/src/main/resources/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> ingredienteDTOS = null;
        try {
            ingredienteDTOS = objectMapper.readValue(file,typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredienteDTOS;
    }
}
