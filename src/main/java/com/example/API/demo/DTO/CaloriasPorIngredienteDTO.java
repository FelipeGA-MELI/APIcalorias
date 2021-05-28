package com.example.API.demo.DTO;

import java.util.Map;

public class CaloriasPorIngredienteDTO {
    Map<String,Integer> caloriasPorIngrediente;

    public Map<String, Integer> getCaloriasPorIngrediente() {
        return caloriasPorIngrediente;
    }

    public void setCaloriasPorIngrediente(Map<String, Integer> caloriasPorIngrediente) {
        this.caloriasPorIngrediente = caloriasPorIngrediente;
    }
}
