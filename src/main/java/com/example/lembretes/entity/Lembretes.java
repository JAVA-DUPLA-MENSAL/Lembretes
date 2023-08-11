package com.example.lembretes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lembretes",schema = "public")
@Getter
@Setter
public class Lembretes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String lembrete;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk")
    private Pessoa pessoa;


}
