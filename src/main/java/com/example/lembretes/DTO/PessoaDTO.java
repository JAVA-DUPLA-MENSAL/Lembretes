package com.example.lembretes.DTO;

import com.example.lembretes.entity.Lembretes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaDTO {

    private Long id;

    private String nome;

    private List<Lembretes> lembretesList;

    public PessoaDTO(){

    }

    public PessoaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        //this.lembretesList = lembretesList;
    }


}

