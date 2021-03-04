package com.gionni.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gionni.forum.controller.dto.TopicoDto;
import com.gionni.forum.controller.form.TopicoForm;
import com.gionni.forum.modelo.Topico;
import com.gionni.forum.repository.CursoRepository;
import com.gionni.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepsitory;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso){ //parametroURL da Query
//		Topico topico = new Topico("Duvida", "Duvida com String", 
//				new Curso("Spring", "Programação"));
		
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepsitory.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepsitory.findByCursoNome(nomeCurso);	
			return TopicoDto.converter(topicos);
		}
	}
	
	@PostMapping
	//ResponseEntity retornando codido 201 HTTP, CREATED.
	public ResponseEntity<TopicoDto> cadastrar (@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepsitory.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	
}
