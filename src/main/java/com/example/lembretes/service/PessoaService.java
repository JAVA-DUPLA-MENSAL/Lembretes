package com.example.lembretes.service;

import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.entity.Lembretes;
import com.example.lembretes.entity.Pessoa;
import com.example.lembretes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private PessoaDTO pessoaDTO;

    private Pessoa pessoa;

    public List<PessoaDTO> findAllNomes(){
        List<Pessoa> listabanco = pessoaRepository.findAll();
        List<PessoaDTO> lista2 = new ArrayList<>();
        for(int i = 0; i< listabanco.size();i++){
            lista2.add(toPessoaDTO((listabanco.get(i))));
        }
        return  lista2;

//        return pessoaRepository.findAll();
    }

    public List<PessoaDTO> findByNome(String nome){
        List<Pessoa> pessoaBanco = pessoaRepository.findPessoaByNome(nome);
        List<PessoaDTO> listPessoaDTO = new ArrayList<>();
        List<Optional<PessoaDTO>> optionals = new ArrayList<>();

        for(int i = 0; i < pessoaBanco.size(); i++){
            listPessoaDTO.add(toPessoaDTO(pessoaBanco.get(i)));

        }
        return listPessoaDTO;

    }

    public void criar(PessoaDTO pessoaDTO){
        toPessoa(pessoaDTO);
        this.pessoaRepository.save(pessoa);
    }

    public void editar(PessoaDTO pessoaDTO){
        this.pessoaRepository.save(pessoa);
    }

    public void deletar(Long id){
        pessoa = pessoaRepository.findById(id).orElse(null);
        pessoaRepository.delete(pessoa);
    }

    public PessoaDTO toPessoaDTO(Pessoa pessoa){
        PessoaDTO pessoa2 = new PessoaDTO();
        pessoa2.setNome(pessoa.getNome());
        pessoa2.setLembretesList(pessoa.getLembrete());
        return pessoa2;
    }

    public Pessoa toPessoa(PessoaDTO pessoaDTO){
        pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setLembrete(pessoaDTO.getLembretesList());
        return pessoa;
    }
}
