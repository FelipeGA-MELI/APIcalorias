package com.example.API.demo.service;

import com.example.API.demo.DTO.AlimentoDTO;
import com.example.API.demo.DTO.CaloriasPorIngredienteDTO;
import com.example.API.demo.DTO.CaloriasTotaisDTO;
import com.example.API.demo.DTO.IngredienteDTO;
import com.example.API.demo.repository.IngredienteRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaloriasService {
    private final IngredienteRepository ingredienteRepository;

    public CaloriasService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public CaloriasTotaisDTO calculaCaloriasTotais(AlimentoDTO alimento) {
        CaloriasTotaisDTO caloriasTotaisDTO = new CaloriasTotaisDTO();

        List<IngredienteDTO> ingredienteDTOList;
        Integer caloriasTotais = 0;

        ingredienteDTOList = alimento.getIngredientesList();

        for(IngredienteDTO ingredienteDTO: ingredienteDTOList) {
            IngredienteDTO ingrediente = ingredienteRepository.findIngredienteByName(ingredienteDTO.getNome());
            caloriasTotais += ingrediente.getCalorias();
        }

        caloriasTotaisDTO.setCaloriasTotais(caloriasTotais);

        return caloriasTotaisDTO;
    }

    public CaloriasPorIngredienteDTO calculaCaloriasPorIngrediente(AlimentoDTO alimento) {
        CaloriasPorIngredienteDTO caloriasPorIngredienteDTO = new CaloriasPorIngredienteDTO();
        Map<String,Integer> caloriasPorIngrediente = new HashMap<>();

        List<IngredienteDTO> ingredienteDTOList = alimento.getIngredientesList();

        for(IngredienteDTO ingrediente: ingredienteDTOList) {
            IngredienteDTO ingredienteDTO = ingredienteRepository.findIngredienteByName(ingrediente.getNome());
            caloriasPorIngrediente.put(ingredienteDTO.getNome(),ingredienteDTO.getCalorias());
        }

        caloriasPorIngredienteDTO.setCaloriasPorIngrediente(caloriasPorIngrediente);

        return caloriasPorIngredienteDTO;
    }

    public IngredienteDTO ingredienteMaisCalorias(AlimentoDTO alimento) {
        List<IngredienteDTO> ingredientesList = alimento.getIngredientesList();
        IngredienteDTO ingredienteDTOresultado = new IngredienteDTO();
        String nomeIngrediente = "";
        Integer caloria = 0;

        for(IngredienteDTO ingredienteDTO: ingredientesList) {
            if(ingredienteDTO.getCalorias() > caloria) {
                caloria = ingredienteDTO.getCalorias();
                nomeIngrediente = ingredienteDTO.getNome();
            }
        }

        ingredienteDTOresultado.setNome(nomeIngrediente);
        ingredienteDTOresultado.setCalorias(caloria);

        return ingredienteDTOresultado;
    }
}
