CREATE TABLE
    IF NOT EXISTS roles(
                           id SERIAL NOT NULL ,
                           name VARCHAR (45)
    );

ALTER TABLE roles ADD CONSTRAINT pk_role
    PRIMARY KEY (id);

CREATE TABLE
    IF NOT EXISTS users (
                            id SERIAL NOT NULL,
                            username VARCHAR (45) NOT NULL UNIQUE,
    email VARCHAR (45) NOT NULL UNIQUE,
    password VARCHAR (45) NOT NULL
    );

ALTER TABLE users ADD CONSTRAINT pk_user
    PRIMARY KEY (id);

CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id BIGINT NOT NULL ,
                                          role_id BIGINT NOT NULL
);

CREATE TABLE
    IF NOT EXISTS profiles (
                               id SERIAL NOT NULL ,
                               user_id BIGINT NOT NULL ,
                               firstname VARCHAR (45) NOT NULL ,
    lastname VARCHAR (45) NOT NULL ,
    created_timestamp TIMESTAMP DEFAULT NOW(),
    updated_timestamp TIMESTAMP DEFAULT NOW()
    );

ALTER TABLE profiles ADD CONSTRAINT pk_profile
    PRIMARY KEY (id);

CREATE TABLE
    IF NOT EXISTS genres (
                             id SERIAL NOT NULL ,
                             name VARCHAR (45) NOT NULL ,
    external_id BIGINT
    );

ALTER TABLE genres ADD CONSTRAINT pk_genre
    PRIMARY KEY (id);

CREATE TABLE
    IF NOT EXISTS movie_genres(
                                  movie_id BIGINT NOT NULL,
                                  genre_id BIGINT NOT NULL
);


CREATE TABLE
    IF NOT EXISTS movies(
                            id BIGSERIAL NOT NULL ,
                            adult BOOLEAN DEFAULT FALSE ,
                            backdrop_path VARCHAR (256) ,
    genre INTEGER  NOT NULL,
    language VARCHAR (45) ,
    title TEXT ,
    overview TEXT
    );

ALTER TABLE movies ADD CONSTRAINT pk_movie
    PRIMARY KEY (id);

CREATE TABLE
    IF NOT EXISTS statuses(
                              id SERIAL NOT NULL ,
                              name VARCHAR (45)
    );

ALTER TABLE statuses ADD CONSTRAINT pk_status
    PRIMARY KEY (id);


CREATE TABLE
    IF NOT EXISTS user_movie(
                                id BIGSERIAL NOT NULL ,
                                user_id BIGINT NOT NULL ,
                                movie_id BIGINT NOT NULL  ,
                                status_id BIGINT NOT NULL ,
                                description TEXT,
                                rating INTEGER ,
                                created_timestamp TIMESTAMP DEFAULT NOW(),
    updated_timestamp TIMESTAMP DEFAULT NOW()
    );

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_user
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_role
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE profiles ADD CONSTRAINT fk_profiles_user
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_genres ADD CONSTRAINT fk_movie_genres_movie
    FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_genres ADD CONSTRAINT fk_movie_genres_genre
    FOREIGN KEY (genre_id) REFERENCES genres (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_movie ADD CONSTRAINT fk_user_movie_user
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_movie ADD CONSTRAINT fk_user_movie_movie
    FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_movie ADD CONSTRAINT fk_user_movie_status
    FOREIGN KEY (status_id) REFERENCES statuses (id) ON DELETE CASCADE ON UPDATE CASCADE;


