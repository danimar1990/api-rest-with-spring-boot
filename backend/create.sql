--create table CARS (id int8 generated by default as identity, brand varchar(255), model varchar(255), year integer, price float, photo oid, primary key (id));
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Audi', 'R8', 2022, 1716991, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Porsche', '911 Carrera GTS', 2022, 1234343, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Mercedes-Benz', 'AMG GT Black Series', 2022, 2314782, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Lamborghini', 'Huracán', 2022, 5104300, null);
INSERT INTO CARS(brand, model, vyear, price, photo) VALUES('Ferrari', 'SF 90 Spider', 2022, 8400000, null);