package com.gionni.forum.controller.dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gionni.forum.modelo.Topico;

public class TopicoDto {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.setTitulo(topico.getTitulo());
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

	public static List<TopicoDto> converter(List<Topico> topicos) {
		//API Stream Java8+
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}

	
	

}
