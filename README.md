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
* Postman
* H2 Console
* MySQL Workbench
* PGAdmin

---

## Sistema:

https://dm-api-rest-with-spring-boot.herokuapp.com/login

## List all cars

https://dm-api-rest-with-spring-boot.herokuapp.com/api/cars

## Search car by id

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/get/{id}

## List car by brand

https://dm-api-rest-with-spring-boot.herokuapp.com/api/cars/brand/{brand-name}

## Insert new car

Body

```json
{
    "brand": "Ferrari",
    "model": "458 Italia",
    "vyear": 2022,
    "price": 1171568.0,
    "photo": ""
}
```

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/create

## Update car

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/update/{id}

Body

```json
{
  "model": "MG GT Black Series",
  "brand": "Mercedes-Benz",
  "photo": null
}
```
## Delete car

https://dm-api-rest-with-spring-boot.herokuapp.com/api/car/delete/{id}
