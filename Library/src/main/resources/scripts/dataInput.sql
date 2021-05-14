INSERT INTO Library.users
(user_name,user_surname,login, password)
VALUES
("Alex", "Konev", "AlexKonev", "010495"),
("Natasha", "Sibiryak", "NatSib", "010784"),
("Dima", "Rubenshtein", "RubDim", "204594"),
("Nikolai", "Vasnetsov", "NikVas", "050845");

INSERT INTO Library.authors
(authorName, authorSurname)
VALUES
("Steven", "King"),
("Max", "Frai"),
("Dina", "Rubina");

INSERT INTO Library.books (bookName, author, description)
VALUES
("Shining", 61, "Horror"),
("Benjamine Bottom", 62, "Fantastic"),
("Cloud Atlas", 63, "Amazing book");

INSERT INTO Library.books (bookName, author, description)
VALUES
("Shining", 62, "Horror"),
("Benjamine Bottom", 61, "Fantastic"),
("Cloud Atlas", 61, "Amazing book");

INSERT INTO Library.records
(user, start_day, end_day)
VALUES
(81, '2019-12-03', '2021-06-03'),
(82, '2020-06-15', '2020-07-15'),
(83, '2020-12-15', '2021-01-15'),
(84, '2021-02-18', '2021-03-18');

INSERT INTO Library.feedback
(book, user, rate, fb_text)
VALUES
(113,81,1,"Something terrible"),
(114,82,5, "It's a greatest book ever!"),
(115,83,5, "I recommend this book to my friends"),
(113,84,3, "It is ordinary book");

INSERT INTO Library.books_records
(book, record)
VALUES
(113,33),
(114,34),
(115,35),
(116,36);