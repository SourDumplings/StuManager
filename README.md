# StuManager
----- 版权所有 酸饺子 -----

Web版学生管理系统

## 功能简介
- 使用MVC设计思想，实现了用户登录，增、删、改、模糊查询以及分页显示的功能
- 使用前应该先在MySQL中建立名为stus的数据库，并建立用户表t_user和stu两张表，具体表项如下：

t_user表：

| username | password  |
| -------- | --------  |
| admin | 123  |

stu表：

| sid | sname | gender | phone | birthday | hobby | info | 
| --- | ----- | ------ | ----- | -------- | ----- | ---- |
| 1 | 酸饺子  | 男 | 12345678901 | 1990-01-01 | 游泳，看书 | 我是中国人 |

## 使用到的技术
- 页面显示：JSP、JavaScript、EL、JSTL
- 数据库管理系统：MySQL
- 数据库连接技术：JDBC、C3P0（连接池）、DBUtils
- 服务器：apache-tomcat-7.0.52
- 服务端程序：Servlet

## 未来将要改进的方向
1.改进生日信息的录入格式，不再是输入字符串而是选日期
2.为页面访问增加限制，限制只能通过login页面进入首页index
3.增加数据库的增加和删除功能，避免还需要准备名为stus数据库的麻烦

## 参考：
[1]黑马程序员.JavaWeb2018-JSP&EL&JSTL

[2]黑马程序员.JavaWeb2018-MVC设计模式
