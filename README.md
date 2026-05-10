# 🎬 RandomFilm

API REST desenvolvida em Java com Spring Boot para consulta de filmes, consumindo a API do [TMDB (The Movie Database)](https://www.themoviedb.org/). O objetivo do projeto é evoluir para um site onde os usuários possam **sortear filmes aleatórios** para assistir.

---

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 4.0.6**
- **TMDB API**

---

## 📋 Endpoints disponíveis

### 🔍 Buscar filme por nome

```
GET /movie?query={nome}
```

Retorna informações de um filme com base no nome pesquisado.

**Exemplo de requisição:**
```
GET /movie?query=Interestellar
```
{  
"title": "Interstellar",  
"overview": "description",  
"popularity": 63.0157,  
"release_date": "2014-11-05",  
"poster_path": "/file.jpg"  
}
---

### 🔥 Listar filmes populares

```
GET /movie/popular
```

Retorna uma lista com os filmes mais populares no momento, de acordo com o TMDB.

---

## ⚙️ Como rodar o projeto

### Pré-requisitos

- Java 21 instalado
- Maven ou Gradle configurado
- Chave de API do TMDB (gratuita em [themoviedb.org](https://www.themoviedb.org/settings/api))

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/LucasLimaAmaral/randomfilm.git
cd randomfilm
```

2. Adicione sua chave da API do TMDB no arquivo `application.properties` (ou `application.yml`):
```properties
tmdb.api.key=SUA_CHAVE_AQUI
```

3. Rode a aplicação:
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 🗺️ Roadmap

- [x] Busca de filme por nome
- [x] Listagem de filmes populares
- [ ] Endpoint de sorteio de filme aleatório
- [ ] Frontend web para sorteio interativo
- [ ] Filtros por gênero, ano e nota

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
