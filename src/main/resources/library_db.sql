CREATE DATABASE lib;
CREATE TABLE book(
	id INT NOT NULL AUTO_INCREMENT,
    title TEXT,
    genre TEXT,
    description TEXT,
    rate INT,
	PRIMARY KEY(id)
);
CREATE TABLE author(
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    country VARCHAR(30),
    age INT,
	PRIMARY KEY(id)
);
INSERT INTO book (
title,
genre,
description,
rate
)
VALUES (
'1984',
'Antiuthopia',
'Ignorance is strength',
'10'
),
(
'test2',
'Drama',
'Simple description',
'9'
),
(
'test3',
'Novel',
'Large description',
'8'
),
(
'test4',
'Essay',
'Another description',
'6'
),
(
'test5',
'Novel',
'Hello world!',
'9'
),
(
'test6',
'Novel',
'All is 42',
'10'
),
(
'test7',
'Essay',
'Just another description',
'5'
),
(
'Bible',
'Religion',
'Religion',
'10'
),
(
'Quoran',
'Religion',
'Abrahamic religion',
'10'
),
(
'test10',
'Science',
'Simple filler',
'5'
);
INSERT INTO author (
firstName,
lastName,
country,
age
)
VALUES (
'Joshua',
'Bloch',
'USA',
'40'
),
(
'Stephen',
'Hawking',
'England',
'70'
),
(
'Oldos',
'Haksli',
'USA',
'73'
),
(
'Bjarne',
'Stroustroup',
'Sweden',
'50'
),
(
'Kathy',
'Sierra',
'USA',
'43'
),
(
'Bert',
'Bates',
'USA',
'46'
),
(
'Bruce',
'Eckel',
'USA',
'54'
),
(
'Michael',
'Morrison',
'USA',
'38'
),
(
'Elisabeth',
'Freeman',
'USA',
'41'
),
(
'Alexander',
'Pushkin',
'Russia',
'32'
);
SELECT * FROM author JOIN book;

SELECT * FROM `book` ORDER BY genre;

SELECT `title`, `genre` FROM `book` ORDER BY rate

SELECT MAX(rate) FROM book

