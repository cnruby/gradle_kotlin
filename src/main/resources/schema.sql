DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO books(title, author) VALUES ('Ruby', 'Leo');
INSERT INTO books(title, author) VALUES ('HTML', 'Jeo');
 