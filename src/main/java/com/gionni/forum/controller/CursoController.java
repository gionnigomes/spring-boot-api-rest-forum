package com.gionni.forum.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gionni.forum.controller.dto.CursoDto;
import com.gionni.forum.modelo.Curso;
import com.gionni.forum.repository.CursoRepository;

@RestController
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository; 
	
	
	@RequestMapping("/cursos")
	public List<CursoDto> retornaCursos() {
		List<Curso> listaCursos = cursoRepository.findAll();
		return CursoDto.converter(listaCursos);
	}
	
}
