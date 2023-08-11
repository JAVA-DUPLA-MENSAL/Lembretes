package com.example.lembretes.service;

import com.example.lembretes.DTO.LembretesDTO;
import com.example.lembretes.entity.Lembretes;
import com.example.lembretes.repository.LembretesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LembretesService {

    @Autowired
    private LembretesRepository lembretesRepository;

    private Lembretes lembretes;

    public void criar(LembretesDTO lembretesDTO){
        tolembretes(lembretesDTO);
        this.lembretesRepository.save(lembretes);
    }

    public LembretesDTO tolembretesDTO(Lembretes lembretes){
        LembretesDTO lembretesDTO = new LembretesDTO();
        lembretesDTO.setPessoa(lembretes.getPessoa());
        lembretesDTO.setLembrete(lembretes.getLembrete());

        return lembretesDTO;
    }

    public Lembretes tolembretes(LembretesDTO lembretesDTO){
        lembretes = new Lembretes();
        lembretes.setPessoa(lembretesDTO.getPessoa());
        lembretes.setLembrete(lembretesDTO.getLembrete());

        return lembretes;
    }

}
