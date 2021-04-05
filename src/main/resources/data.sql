INSERT INTO Book (Title, Year, Publishing)
VALUES ('1984', 1949, 'Secker and Warburg'),
       ('Witcher', 1986, 'superNOWA'),
       ('The Lord of the Rings', 1954, 'George Allen & Unwin'),
       ('Harry Potter', 1997, 'Bloomsbury'),
       ('Thinking in Java', 1998, 'Prentice Hall');


INSERT INTO Author (Name, Surname, Birthday, Gender)
VALUES ('john', 'Eckel', '1957-7-8', 'Male'),
       ('Andrzej', 'Sapkowski', '1948-6-21', 'Male'),
       ('Joanne', 'Rowling', '1965-7-31', 'Female'),
       ('John', 'Tolkien', '1892-1-3', 'Male'),
       ('George', 'Orwell', '1903-6-25', 'Male');


INSERT INTO Book_Author (BookId, AuthorId)
VALUES (1, 5),
       (2, 2),
       (3, 4),
       (4, 3),
       (5, 1);

