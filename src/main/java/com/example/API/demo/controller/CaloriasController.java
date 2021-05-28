package com.example.API.demo.controller;

import com.example.API.demo.DTO.AlimentoDTO;
import com.example.API.demo.DTO.CaloriasPorIngredienteDTO;
import com.example.API.demo.DTO.CaloriasTotaisDTO;
import com.example.API.demo.DTO.IngredienteDTO;
import com.example.API.demo.service.CaloriasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CaloriasController {
    private CaloriasService caloriasService;

    public CaloriasController(CaloriasService caloriasService) {
        this.caloriasService = caloriasService;
    }

    @PostMapping("/CaloriasTotais")
    public CaloriasTotaisDTO calculaCaloriasTotais(@RequestBody AlimentoDTO alimento) {
        return caloriasService.calculaCaloriasTotais(alimento);
    }

    @PostMapping("/CaloriasPorIngrediente")
    public CaloriasPorIngredienteDTO calculaCaloriasPorIngrediente(@RequestBody AlimentoDTO alimento) {
        return caloriasService.calculaCaloriasPorIngrediente(alimento);
    }

    @PostMapping("/AlimentoComMaisCalorias")
    public IngredienteDTO ingredienteMaisCalorias(@RequestBody AlimentoDTO alimento) {
        return caloriasService.ingredienteMaisCalorias(alimento);
    }
}
