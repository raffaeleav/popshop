DROP database if exists modelloMVCdb;
CREATE database modelloMVCdb;
USE modelloMVCdb;

CREATE table utente(
	idutente int primary key not null auto_increment,
    nome varchar(30),
    cognome varchar(30),
    email varchar(30),
    passw varchar(30),
    indirizzo varchar(30),
    cartacr varchar(20)
)
;

CREATE table capo(
	idcapo int primary key not null auto_increment,
    nome varchar(30),
    marca varchar(30),
    prezzo double,
    taglia varchar(5),
    immagine varchar(100)
)
;

CREATE table scarpe(
	idscarpe int primary key not null auto_increment,
    nome varchar(30),
    marca varchar(30),
    prezzo double,
    numero double,
    immagine varchar(100)
)
;

CREATE table accessorio(
	idaccessorio int primary key not null auto_increment,
    nome varchar(30),
    marca varchar(30),
    prezzo double,
    immagine varchar(100)
)
;

CREATE table acquistare(
	idutente int,
    idcapo int,
    idscarpe int,
    idaccessorio int,
    foreign key(idutente) references utente(idutente),
	foreign key(idcapo) references capo(idcapo),
	foreign key(idscarpe) references scarpe(idscarpe),
	foreign key(idaccessorio) references accessorio(idaccessorio)
)
;

INSERT INTO utente(nome,cognome,email,passw,indirizzo,cartacr) values 
("admin","admin","admin@popshop.it","sPopadmin!","Via San Rocco 8", "0000000000000000"),
("Marco","Rossi","marcor@gmail.it","mArio123!","Via Brombeis 5", "8735255431228999")
;

INSERT INTO capo(marca,nome,prezzo,immagine) values 
("Bershka","Faded T-Shirt", 30, "abbigliamento/Faded T-Shirt.jpg"),
("Bershka","Painting T-Shirt", 30, "abbigliamento/Painting T-Shirt.jpg"),
("Adidas","Performance T-Shirt", 40, "abbigliamento/Performance T-Shirt.jpg")
;

INSERT INTO scarpe(marca,nome,prezzo,immagine) values 
("Nike", "AIR Jordan 1 MID", 130, "footwear/AIR Jordan 1 MID.jpg"),
("Nike", "Blazer 77 JUMBO", 100, "footwear/Blazer 77 JUMBO.jpg"),
("Converse", "Chuck Taylor ALL STAR", 110, "footwear/Chuck Taylor ALL STAR.jpg")
;

INSERT INTO accessorio(marca,nome,prezzo,immagine) values 
("New Era", "9FORTY", 15, "accessori/9FORTY.jpg"),
("Calvin Klein", "Vital BIFOLD", 30, "accessori/Vital BIFOLD.jpg")
;