DROP TABLE IF EXISTS MOVIE;

CREATE TABLE MOVIE (
  name VARCHAR(250) NOT NULL PRIMARY KEY,
  genre VARCHAR(250) NOT NULL
  );

INSERT INTO MOVIE (name, genre) VALUES
  ('Titanic', 'Romantic'),
  ('1917', 'War')