package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;
	
		
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Aluno aluno1 = new Aluno();
		aluno1.setEmail("lucas@gmail.com");
		aluno1.setNome("Lucas");
		aluno1.setSobreNome("Silva");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setEmail("gabriel@gmail.com");
		aluno2.setNome("Gabriel");
		aluno2.setSobreNome("Silva");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setEmail("karen@gmail.com");
		aluno3.setNome("Karen");
		aluno3.setSobreNome("Silva");
		alunoService.salvar(aluno3);
		
		
		List<Aluno> listaAlunos =  alunoService.buscarTodosAlunos();
		listaAlunos.forEach(aluno -> System.out.println(aluno.getNome()));
		
		
		//Boolean flag = alunoService.deleteAluno(1);
		//System.out.println(flag);
		
		Aluno alunoAlterado = new Aluno();
		
		alunoAlterado.setEmail("luccas@gmail.com");
		alunoAlterado.setNome("Luccas");
		alunoAlterado.setSobreNome("Silva");
		Aluno alunoAtualizado = alunoService.updateAluno(1, alunoAlterado);
		System.out.println("Aluno alterado: " + alunoAtualizado.getEmail());
		
	}

	
	
}
