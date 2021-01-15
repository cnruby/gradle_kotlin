DROP TABLE IF EXISTS books;

DROP SEQUENCE IF EXISTS native;
CREATE SEQUENCE native START 5;

CREATE TABLE books (
  id serial PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250)
--  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO books(title, author) VALUES ('Ruby', 'Leo 215B');
INSERT INTO books(title, author) VALUES ('HTML', 'Jeo 215B');
