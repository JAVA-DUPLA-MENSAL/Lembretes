package com.example.lembretes;

import com.example.lembretes.DTO.LembretesDTO;
import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.controller.LembretesController;
import com.example.lembretes.controller.PessoaController;
import com.example.lembretes.entity.Lembretes;
import com.example.lembretes.entity.Pessoa;
import com.example.lembretes.repository.LembretesRepository;
import com.example.lembretes.repository.PessoaRepository;
import com.example.lembretes.service.PessoaService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LembretesApplicationTests {

	@MockBean
	PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private PessoaController pessoaController;

	@Autowired
	private LembretesController lembretesController;

	@BeforeEach
	void injectData(){
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa(1L, "Carlos"));
		Pessoa pessoaCreate = new Pessoa(1L,"Galio");

		List<Lembretes> lembretes = new ArrayList<>();
		lembretes.add(new Lembretes( 1L,"lembrete de teste1",pessoas.get(0)));

		//System.out.println("antes do mockito "+lembretes.size());

		Mockito.when(pessoaRepository.findPessoaByNome("Carlos")).thenReturn(pessoas);
		Mockito.when(pessoaRepository.save(pessoaCreate)).thenReturn(pessoaCreate);

		//System.out.println("depois do mockito "+lembretes.size() + "  "+lembretes.get(0).getLembrete()+ "  "+lembretes.get(0).getPessoa().getNome());

	}

	@Test
	void testeControllerPessoaFindByNome() {
		var d = pessoaService.findByNome("Carlos");
		//System.out.println(d.get(0).getNome());
		Assert.assertEquals("Carlos",d.get(0).getNome());
	}

	//____________________________________________________

	@Test
	void testeControllerPessoaEditar(){
		var dump = pessoaController.editar(1L,new PessoaDTO(1L, "Roberto"));

		//var nome = pessoaController.findByNome("Roberto");

		Assert.assertEquals("Editado com sucesso", dump.getBody());

	}

	@Test
	void testeControllerPessoaCadastro(){
		var pessoaDumpCreate = pessoaController.criar(new PessoaDTO(1L, "Galio"));

		Assert.assertEquals("Pessoa cadastrada", pessoaDumpCreate.getBody());
	}

	@Test
	void testeControllerPessoaDeletar(){
		var pessoaDumpDelete = pessoaController.deletar(1L);

		Assert.assertEquals("Objeto deletado",pessoaDumpDelete.getBody());
	}

	@Test
	void testeControllerLembretesCadastrar(){
		var pessoaDumpCadastro =  lembretesController.cadastrar(new LembretesDTO(1L, "este e um lembrete",new Pessoa(1L,"Galio")));

		Assert.assertEquals("lembrete cadastrado", pessoaDumpCadastro.getBody());
	}

}
