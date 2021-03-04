package com.gionni.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gionni.forum.modelo.Topico;

//Interfaces nao precisam colocar anotações, o Spring só necessita de anotações em classes
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//Spring gerando a consulta automaticamente, utilizando a convenção.
	List<Topico> findByCursoNome(String nomeCurso);
	
	//Usando metodos fora da convenção do Spring JPA (gerar query manual)	
	//@Query("SELECT t FROM TOPICO where t.curso.nome = :nomeCurso")
	//List<Topico> carregarPorNomeDoCurso(String nomeCurso);
	

}
