# Análise e Desenvolvimento de Sistemas - UNOESC
Componente Curricular: Computação em Nuvem e Internet das Coisas<br>
Professor: Herculano De Biasi<br>
Acadêmicos: Danimar Henrique Varisa, Michael Timbola

### Arquitetura de Sistemas em nuvem
Proposta: Desenvolvimento de uma API Rest com Spring Boot & React Native

Tecnologias Back-end utilizadas:<br>
* Java 11;
* SpringBoot;
* SpringSecurity;
* ..and others;

Tecnologias Front-end utilizadas:<br>
* React;
* Bootstrap 5;
* MDB

Bancos de dados:<br>
* H2
* MySQL
* PostgreSQL

Ferramentas:<br>
* Spring Tool Suite
* VSCode
* H2 Console
* MySQL Workbench
* PGAdmin

---

## Sistema:

https://dm-api-rest-with-spring-boot.herokuapp.com/
https://dm-api-rest-with-spring-boot.vercel.app/

## Lista de carros

https://dm-api-rest-with-spring-boot.herokuapp.com/api/cars
https://dm-api-rest-with-spring-boot.vercel.app/api/cars

## Buscar carro pelo código

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/{id}
https://dm-api-rest-with-spring-boot.vercel.app/car/{id}

## Listar carros por marca

https://dm-api-rest-with-spring-boot.herokuapp.com/api/cars/brand/{brand-name-here}
https://dm-api-rest-with-spring-boot.vercel.app/brand/{brand-name-here}

## Criar novo carro

Body

```json
{
  "model": "MG GT Black Series",
  "brand": "Mercedes-Benz",
  "photo": null
}
```

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/save
https://dm-api-rest-with-spring-boot.vercel.app/car/save

## Atualizar carro

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/{id}/update
https://dm-api-rest-with-spring-boot.vercel.app/car/{id}/update

Body

```json
{
  "model": "MG GT Black Series",
  "brand": "Mercedes-Benz",
  "photo": null
}
```
## Excluir carro

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/{id}/delete
https://dm-api-rest-with-spring-boot.vercel.app/{id}/delete
