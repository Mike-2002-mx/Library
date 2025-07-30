CREATE TABLE authors (
  id_author SERIAL PRIMARY KEY,
  author_name VARCHAR(50) NOT NULL CHECK (author_name <> ''),
  last_name VARCHAR(100) NOT NULL CHECK (last_name <> ''),
  nationality VARCHAR(100) NOT NULL CHECK (nationality <> '')
);

CREATE TABLE genres (
  id_genre SERIAL PRIMARY KEY,
  name_genre VARCHAR(100) NOT NULL CHECK (name_genre <> '')
);

CREATE TABLE collections (
  id_collection SERIAL PRIMARY KEY,
  name_collection VARCHAR(100) NOT NULL CHECK (name_collection <> '')
);

CREATE TABLE publishers (
  id_publisher SERIAL PRIMARY KEY,
  name_publisher VARCHAR(100) NOT NULL CHECK (name_publisher <> ''),
  country VARCHAR(100) NOT NULL CHECK (country <> '')
);

CREATE TABLE users (
  id_user SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL CHECK (name <> ''),
  last_name VARCHAR(100) NOT NULL CHECK (last_name <> ''),
  phone VARCHAR(50) UNIQUE NOT NULL CHECK (phone <> ''),
  password VARCHAR(255) NOT NULL CHECK (password <> ''),
  address VARCHAR(255) NOT NULL CHECK (address <> ''),
  user_type VARCHAR(50) NOT NULL CHECK (user_type <> ''),
  active BOOLEAN NOT NULL
);

CREATE TABLE books (
  id_book SERIAL PRIMARY KEY,
  title VARCHAR(150) NOT NULL CHECK (title <> ''),
  id_publisher INT NOT NULL, 
  id_collection INT NOT NULL,
  publication_year INT NOT NULL,
  summary VARCHAR(255) NOT NULL CHECK (summary <> ''),
  number_pages INT NOT NULL,
  total_copies INT NOT NULL,
  FOREIGN KEY(id_publisher) REFERENCES publishers(id_publisher),
  FOREIGN KEY(id_collection) REFERENCES collections(id_collection)
);

CREATE TABLE books_authors (
  id SERIAL PRIMARY KEY,
  id_book INT NOT NULL,
  id_author INT NOT NULL,
  FOREIGN KEY(id_book) REFERENCES books(id_book),
  FOREIGN KEY(id_author) REFERENCES authors(id_author)
);

CREATE TABLE books_genres (
  id SERIAL PRIMARY KEY,
  id_book INT NOT NULL,
  id_genre INT NOT NULL,
  FOREIGN KEY(id_book) REFERENCES books(id_book),
  FOREIGN KEY(id_genre) REFERENCES genres(id_genre)
);

-- CREATE TYPE state_copy AS ENUM ('disponible', 'prestado', 'dañado', 'perdido');

-- CREATE TABLE book_copies (
--   id SERIAL PRIMARY KEY,
--   id_book INT NOT NULL,
--   state state_copy NOT NULL, 
--   updated_at TIMESTAMP DEFAULT now(),
--   FOREIGN KEY(id_book) REFERENCES books(id_book)
-- );

-- CREATE TYPE loan_status AS ENUM ('activo', 'devuelto', 'vencido', 'cancelado');

-- CREATE TABLE loans (
--   id SERIAL PRIMARY KEY,
--   id_user INT NOT NULL,
--   id_book_copy INT NOT NULL,
--   loan_date DATE NOT NULL DEFAULT CURRENT_DATE,
--   due_date DATE NOT NULL,
--   return_date DATE,
--   status loan_status NOT NULL DEFAULT 'activo',
--   summary VARCHAR(255),
--   FOREIGN KEY (id_user) REFERENCES users(id_user),
--   FOREIGN KEY (id_book_copy) REFERENCES book_copies(id)
-- );
