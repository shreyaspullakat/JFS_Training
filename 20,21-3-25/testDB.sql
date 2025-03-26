SHOW DATABASES;
create database testdb;
use testdb;
CREATE TABLE Users (
    userId INT(10) PRIMARY KEY AUTO_INCREMENT,
    username char(50),
    email CHAR(50) UNIQUE,
    userpass CHAR(50) NOT NULL
);
drop table Users;
INSERT INTO users (username,email, userpass) VALUES ('ponraj','ponraj@gmail.com', 'ponraj@123');
INSERT INTO users (username,email, userpass) VALUES ("niki",'niki362004@gmail.com', 'niki@123');
INSERT INTO users (username,email, userpass) VALUES ('xcv','xcvbnm362004@gmail.com', 'qwertyi@123'), ('asd','asdfghhjj04@gmail.com', 'qoiuytrewq3');
SELECT * FROM users ;