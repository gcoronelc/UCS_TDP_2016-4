USE MYSQL;

GRANT ALL PRIVILEGES ON *.* TO 'eureka'@'%' 
IDENTIFIED BY 'admin' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON *.* TO 'eureka'@'localhost' 
IDENTIFIED BY 'admin' WITH GRANT OPTION;

FLUSH PRIVILEGES;
