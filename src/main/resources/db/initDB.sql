
DROP TABLE IF EXISTS users_vote;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS users_seq;

DROP TABLE IF EXISTS restaurants_menu;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS restaurants_seq;


CREATE SEQUENCE users_seq       START 100000;
CREATE SEQUENCE restaurants_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('users_seq'),
  name             VARCHAR                  NOT NULL,
  email            VARCHAR                  NOT NULL,
  password         VARCHAR                  NOT NULL,
  registered       TIMESTAMP DEFAULT now()  NOT NULL,
  enabled          BOOL DEFAULT TRUE        NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants (
  id          INTEGER PRIMARY KEY DEFAULT nextval('restaurants_seq'),
  description TEXT      NOT NULL,
  address     TEXT       NOT NULL
);

CREATE TABLE restaurants_menu (
  restaurant_id     INTEGER   NOT NULL,
  data              TIMESTAMP NOT NULL,
  dish              TEXT      NOT NULL,
  price             INT       NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX restaurants_menu_unique_data_idx ON restaurants_menu (data);

CREATE TABLE  users_vote (
  user_id           INTEGER   NOT NULL,
  restaurant_id     INTEGER   NOT NULL,
  data              TIMESTAMP NOT NULL,
  voice             INT       NOT NULL,
  FOREIGN KEY (user_id)       REFERENCES users (id)       ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_vote_unique_data_idx ON users_vote (data);
