# springboot-druid
srpingboot-druid-mybatis(mysql)

# mysql

## 启动镜像
docker run --name=server-mysql -d -p 3306:3306 mysql/mysql-server

## 初始密码生成
docker logs mysql1 2>&1 | grep GENERATED
user: root password:   &4SUh^0wV0D0PoMOJdiNUdRIx4N

## 修改数据库密码
ALTER USER 'root'@'localhost' IDENTIFIED BY '123';

## 创建数据库
CREATE DATABASE IF NOT EXISTS test DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
## 赋予访问权限
GRANT ALL PRIVILEGES ON *.* TO ‘root’@'%’ IDENTIFIED BY ‘123’ WITH GRANT OPTION;

# docker exec -it containername /bin/bash

<code>
mysql> desc test;<br />
+-------+----------+------+-----+---------+----------------+<br />
| Field | Type     | Null | Key | Default | Extra          |<br />
+-------+----------+------+-----+---------+----------------+<br />
| id    | int(4)   | NO   | PRI | NULL    | auto_increment |<br />
| name  | char(20) | NO   |     | NULL    |                |<br />
+-------+----------+------+-----+---------+----------------+<br />
2 rows in set (0.00 sec)<br />
</code>

# druid访问地址
http://localhost:8081/druid/
