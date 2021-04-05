DROP TABLE IF EXISTS Book_Author;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;

CREATE TABLE Book
(
    Id         INT AUTO_INCREMENT PRIMARY KEY,
    Title      VARCHAR(255) NOT NULL,
    Year       INT          NOT NULL,
    Publishing VARCHAR(255) NOT NULL
);

CREATE TABLE Author
(
    Id       INT AUTO_INCREMENT PRIMARY KEY,
    Name     VARCHAR(255) NOT NULL,
    Surname  VARCHAR(255) NOT NULL,
    Birthday DATE         NOT NULL,
    Gender   VARCHAR(255) NOT NULL
);

CREATE TABLE Book_Author
(
    BookId   INT,
    AuthorId INT,
    FOREIGN KEY (BookId) REFERENCES Book (Id),
    FOREIGN KEY (AuthorId) REFERENCES Author (Id)
)

