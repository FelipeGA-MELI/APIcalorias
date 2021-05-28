package com.example.API.demo.DTO;

import java.util.List;

public class AlimentoDTO {
    private String nome;
    private List<IngredienteDTO> ingredientesList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<IngredienteDTO> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<IngredienteDTO> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }
}
