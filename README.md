# springboot-druid
srpingboot-druid-mybatis(mysql)

mysql

docker run --name=server-mysql -d -p 3306:3306 mysql/mysql-server
user: root password:   &4SUh^0wV0D0PoMOJdiNUdRIx4N

ALTER USER 'root'@'localhost' IDENTIFIED BY '123';


CREATE DATABASE IF NOT EXISTS test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON *.* TO ‘root’@'%’ IDENTIFIED BY ‘123’ WITH GRANT OPTION;


docker exec -it containername /bin/bash

mysql> desc test;<br />
+-------+----------+------+-----+---------+----------------+<br />
| Field | Type     | Null | Key | Default | Extra          |<br />
+-------+----------+------+-----+---------+----------------+<br />
| id    | int(4)   | NO   | PRI | NULL    | auto_increment |<br />
| name  | char(20) | NO   |     | NULL    |                |<br />
+-------+----------+------+-----+---------+----------------+<br />
2 rows in set (0.00 sec)<br />


http://localhost:8081/druid/
