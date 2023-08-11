package com.example.lembretes.DTO;

import com.example.lembretes.entity.Lembretes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaDTO {

    private String nome;

    private List<Lembretes> lembretesList;

}

