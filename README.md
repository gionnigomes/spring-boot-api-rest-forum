# API Rest com Spring Boot - Fórum

API desenvolvida com Spring Boot onde retorna dados armazenados em banco de dados em memória.
Os dados retornados são cursos, tópicos e dúvidas do fórum.

#@GetMapping
/cursos - retorna todos os cursos cadastrados no Banco 
/topicos - retorna todos os tópicos cadastrados no Banco

@PostMapping
Cadastrar tópico via post, usando exemplo de JSON no postman:
{
    "titulo": "Duvida Spring Boot e Spring Data JPA",
    "mensagem": "Erro ao fazer annotation",
    "nomeCurso": "Spring Data JPA"
}

O retorno do post seria outro Json com ID autoincrementado do banco e com data de criação do tópico, ex:
{
     "id": 5,
    "titulo": "Duvida Spring Boot e Spring Data JPA",
    "mensagem": "Erro ao fazer annotation",
    "dataCriacao": "2021-03-04T13:15:13.6409716"
}
}


Passando parametros via get retornando tópicos do Curso passado:
Ex: http://localhost:8090/topicos?nomeCurso=Spring%20Boot


