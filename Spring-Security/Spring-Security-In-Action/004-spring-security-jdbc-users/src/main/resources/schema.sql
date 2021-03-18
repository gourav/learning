CREATE TABLE IF NOT EXISTS users
(
    id       INT          NOT NULL AUTO_INCREMENT,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  boolean      NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS authorities
(
    id        INT         NOT NULL AUTO_INCREMENT,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(45) NOT NULL,

    PRIMARY KEY (id)
);