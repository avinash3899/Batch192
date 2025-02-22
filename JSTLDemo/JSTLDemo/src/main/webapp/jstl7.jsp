<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
  
<html>  
<head>  
<title>sql:query Tag</title>  
</head>  
<body>  
   
<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver"  
     url="jdbc:oracle:thin:@localhost:1521:XE"  
     user="system"  password="1234"/>  
  
<sql:query dataSource="${db}" var="rs">  
SELECT * from emp  
</sql:query>  
   
<table border="2" width="100%">  
<tr>  
<th>EmpNo</th>  
<th>First Name</th>  
<th>Address</th>  

</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.empno}"/></td>  
<td><c:out value="${table.Name}"/></td>  
<td><c:out value="${table.address}"/></td>  
</tr>  
</c:forEach>  
</table>  
  
</body>  
</html>  