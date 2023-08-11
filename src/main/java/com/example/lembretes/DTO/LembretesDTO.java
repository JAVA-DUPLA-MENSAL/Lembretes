package com.example.lembretes.DTO;

import com.example.lembretes.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LembretesDTO {

    private String lembrete;

    private Pessoa pessoa;


}
