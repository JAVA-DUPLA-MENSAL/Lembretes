package com.example.lembretes.controller;

import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.entity.Lembretes;
import com.example.lembretes.entity.Pessoa;
import com.example.lembretes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaDTO>> findAll(){
        try{
            return ResponseEntity.ok(pessoaService.findAllNomes());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/buscarnome/{nome}")
    public ResponseEntity<List<PessoaDTO>> findByNome(@PathVariable("nome")String nome){
        try{
            return ResponseEntity.ok(this.pessoaService.findByNome(nome));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criar(@RequestBody PessoaDTO pessoaDTO){
        try{
            pessoaService.criar(pessoaDTO);
            return ResponseEntity.ok().body("Pessoa cadastrada");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@RequestParam("id")final Long id, @RequestBody PessoaDTO pessoaDTO){
        try{
            this.pessoaService.editar(pessoaDTO);
            return  ResponseEntity.ok().body("Editado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") final Long id){
        try{
            this.pessoaService.deletar(id);
            return ResponseEntity.ok("Objeto deletado");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
