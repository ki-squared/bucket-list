# bucket-list
2021학년도 카카오트랙 포털서비스개발방법론 기말 프로젝트(개인과제)

### 버킷리스트 관리 웹 애플리케이션
Dependencies | Used
----- | -----
Developer Tools | Spring Boot DevTools, Lombok
Web | Spring Web
Template Engines | Thymeleaf
SQL | Spring Data JPA, H2 Database, MySQL Driver

### DB(MySQL)
mysql> desc userinfo;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int         | NO   | PRI | NULL    | auto_increment |
| name     | varchar(32) | YES  |     | NULL    |                |
| password | varchar(32) | YES  |     | NULL    |                |
| email    | varchar(32) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

mysql> desc list;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| title | varchar(50) | NO   | PRI | NULL    |       |
| count | int         | YES  |     | 0       |       |
+-------+-------------+------+-----+---------+-------+

mysql> desc mylist;
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| title   | varchar(50) | NO   | PRI | NULL    |       |
| comment | varchar(50) | YES  |     | NULL    |       |
| date    | date        | YES  |     | NULL    |       |
| id      | int         | NO   | PRI | NULL    |       |
+---------+-------------+------+-----+---------+-------+
-> foreign key title references list(title)
-> foreign key id references userinfo(id)


### 로그인 기능 구현
Ajax(JS), Session(Java) 활용


### Reference
1. https://admm.tistory.com/54]
2. https://jobc.tistory.com/120
3. http://blog.naver.com/PostView.nhn?blogId=namoyo&logNo=110166980135&parentCategoryNo=82&categoryNo=&viewDate=&isShowPopularPosts=true&from=search
4. http://www.tcpschool.com/jquery/jq_intro_apply
5. https://rios.tistory.com/entry/Java-%EC%84%B8%EC%85%98Session-%EC%9D%98-%EC%A0%95%EC%9D%98%EC%99%80-%ED%99%9C%EC%9A%A9-%EC%98%88
