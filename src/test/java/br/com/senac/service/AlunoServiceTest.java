package br.com.senac.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@SpringBootTest
class AlunoServiceTest {
	
	
	private static final Integer ID = 1;
	
	private static final String NOME = "Lucas";
	
	private static final String SOBRENOME = "Silva";
	
	private static final String EMAIL = "lucas@gmail.com";
	
	private Aluno aluno;
	private Optional<Aluno> alunoOptional;
	
	
	@InjectMocks
	private AlunoService alunoService;
		
	@Mock
	private AlunoRepository alunoRepository;
	
	@Mock
	private ModelMapper mapper;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		startAluno();
		
	}
	
	
	private void startAluno() {
		aluno = new Aluno(ID,NOME,SOBRENOME,EMAIL);
		alunoOptional = Optional.of(new Aluno(ID,NOME,SOBRENOME,EMAIL));
	}
	
	
	@Test
	void whenFindByIdThenReturnAnAlunoInstance() {
	
		Mockito.when(alunoRepository.findById(Mockito.anyInt())).thenReturn(alunoOptional);
		Aluno response = alunoService.getAlunoByID(ID);
		Assertions.assertEquals(Aluno.class, response.getClass());
		Assertions.assertEquals(ID, response.getId());
		Assertions.assertEquals(NOME, response.getNome());
		Assertions.assertEquals(SOBRENOME, response.getSobreNome());
		Assertions.assertEquals(EMAIL, response.getEmail());
		
	}
	
	
	@Test
	void whenFindAllThenReturnListOfAluno() {
	
		Mockito.when(alunoRepository.findAll()).thenReturn(List.of(aluno));
		List<Aluno> response = alunoService.buscarTodosAlunos();
		Assertions.assertNotNull(response);
		Assertions.assertEquals(1, response.size());
		Assertions.assertEquals(ID, response.get(0).getId());
		Assertions.assertEquals(NOME, response.get(0).getNome());
		Assertions.assertEquals(SOBRENOME, response.get(0).getSobreNome());
		Assertions.assertEquals(EMAIL, response.get(0).getEmail());
		
	}
	
	@Test
	void whenCreateThenReturnSucess() {
		Mockito.when(alunoRepository.save(any())).thenReturn(aluno);
		Aluno response = alunoService.salvar(aluno);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Aluno.class, response.getClass());
		Assertions.assertEquals(ID, response.getId());
		Assertions.assertEquals(NOME, response.getNome());
		Assertions.assertEquals(SOBRENOME, response.getSobreNome());
		Assertions.assertEquals(EMAIL, response.getEmail());
	}
	
	
	
	
	

	@Test
	void testSalvar() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarTodosAlunos() {
		fail("Not yet implemented");
	}

	

	@Test
	void testDeleteAluno() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAluno() {
		fail("Not yet implemented");
	}

}
