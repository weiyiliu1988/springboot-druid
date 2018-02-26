# springboot-druid
srpingboot-druid-mybatis(mysql)

mysql

docker run --name=server-mysql -d -p 3306:3306 mysql/mysql-server
user: root password:   &4SUh^0wV0D0PoMOJdiNUdRIx4N

ALTER USER 'root'@'localhost' IDENTIFIED BY '123';


CREATE DATABASE IF NOT EXISTS test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON *.* TO ‘root’@'%’ IDENTIFIED BY ‘123’ WITH GRANT OPTION;


docker exec -it containername /bin/bash

mysql> desc test;
+-------+----------+------+-----+---------+----------------+
| Field | Type     | Null | Key | Default | Extra          |
+-------+----------+------+-----+---------+----------------+
| id    | int(4)   | NO   | PRI | NULL    | auto_increment |
| name  | char(20) | NO   |     | NULL    |                |
+-------+----------+------+-----+---------+----------------+
2 rows in set (0.00 sec)
