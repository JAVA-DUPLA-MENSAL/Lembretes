package com.example.lembretes.controller;

import com.example.lembretes.DTO.LembretesDTO;
import com.example.lembretes.service.LembretesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/lembretes")
public class LembretesController {

    @Autowired
    private LembretesService lembretesService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody LembretesDTO lembretesDTO){
        try{
            lembretesService.criar(lembretesDTO);
            return ResponseEntity.ok("lembrete cadastrado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
