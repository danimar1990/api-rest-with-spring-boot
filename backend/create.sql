create table cars (id int8 generated by default as identity, brand varchar(255), model varchar(255), photo oid, price float4 not null, vyear int4 not null, primary key (id));
create table perfil (id int8 generated by default as identity, tipo varchar(255), primary key (id));
create table users_perfil (user_id int8 not null, role_id int8 not null, primary key (user_id, role_id));
create table usuario (id int8 generated by default as identity, nome varchar(255), senha varchar(255), usuario varchar(255), primary key (id));
alter table if exists users_perfil add constraint FKpmdd69hv23gvo8r5ok9f8rub foreign key (role_id) references perfil;
alter table if exists users_perfil add constraint FKj76y1o5mku5oc2v4m16lqxwhm foreign key (user_id) references usuario;
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Audi', 'R8', 2022, 1716991, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Porsche', '911 Carrera GTS', 2022, 1234343, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Mercedes-Benz', 'AMG GT Black Series', 2022, 2314782, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Lamborghini', 'Huracán', 2022, 5104300, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Ferrari', 'SF 90 Spider', 2022, 8400000, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('BMW', 'M8 Gran Coupé Competition', 2022, 1320950, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Aston Martin', 'Vantage S', 2022, 1100089.50, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Rolls-Royce', 'Cullinan Black Badge', 2022, 7706492, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Maserati', 'Levante Trofeo', 2022, 2799895, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Land Rover', 'Range Rover Sport SVR SUPERCHA', 2022, 1051076, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Nissan', 'GTR50 Special Edition', 2022, 4000000, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Wolkswagen', 'Fuque 1600', 1975, 100000, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Ferrari', '"458 Spider"', 2015, 2786278, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Ferrari', '"SF 90 STRADALE"', 2022, 7406252, null);