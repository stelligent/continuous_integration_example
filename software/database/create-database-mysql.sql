DROP DATABASE IF EXISTS brewery;
CREATE DATABASE brewery;

GRANT ALL PRIVILEGES ON brewery.* TO 'brewuser'@'localhost' IDENTIFIED BY 'password' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON brewery.* TO 'brewuser'@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost'
    IDENTIFIED BY 'mysql' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost'
    IDENTIFIED BY 'mysql' WITH GRANT OPTION;
