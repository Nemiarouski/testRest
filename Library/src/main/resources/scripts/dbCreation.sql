CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(30),
    user_surname VARCHAR(30),
    login VARCHAR(10),
    password VARCHAR(10)
);

CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    authorName VARCHAR(30),
    authorSurname VARCHAR(30)
);

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookName VARCHAR(70),
    author INT,
    description VARCHAR (100),
    FOREIGN KEY (author) REFERENCES authors(id)
);

CREATE TABLE records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user INT,
    start_day DATE,
    end_day DATE,
    FOREIGN KEY (user) REFERENCES users(id)
);

CREATE TABLE books_records (
    book INT,
    record INT,
    FOREIGN KEY (book) REFERENCES books(id),
    FOREIGN KEY (record) REFERENCES records(id)
);

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book INT,
    user INT,
    rate INT,
    fb_text VARCHAR(200),
    FOREIGN KEY (user) REFERENCES users(id),
    FOREIGN KEY (book) REFERENCES books(id)
);


