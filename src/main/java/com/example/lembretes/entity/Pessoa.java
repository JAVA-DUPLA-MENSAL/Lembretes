package com.example.lembretes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "pessoa", schema ="public")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "pessoa")
    @JsonBackReference
    private List<Lembretes> lembrete;
    public Pessoa(){}


    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
