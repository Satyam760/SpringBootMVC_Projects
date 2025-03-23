<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<%-- <c:choose>
	<c:when test="${!empty result}">
	  <h1 style="color:brown;text-align:center">Employees Report</h1>
	  <table border="1" align="center" bgcolor="cyan">
	     <tr style=color:brown><th>Employee no</th><th>Employee name</th><th>job</th><th>salary</th></tr>
	     <c:forEach var="emp" items="${result}">
	       <tr style="color:blue">
	         <td>${emp.empno}</td>
	         <td>${emp.ename}</td>
	         <td>${emp.job}</td>
	         <td>${emp.sal}</td>
	       </tr>
	     </c:forEach>
	  </table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align=center">Employees Not Found</h1>
	</c:otherwise>
</c:choose> --%>


<%--adding update and delete home hyper link --%>
<c:choose>
	<c:when test="${!empty result}">
	  <h1 style="color:brown;text-align:center">Employees Report</h1>
	  <table border="1" align="center" bgcolor="cyan">
	     <tr style=color:brown><th>Employee no</th><th>Employee name</th><th>job</th><th>salary</th></tr>
	     <c:forEach var="emp" items="${result}">
	       <tr style="color:blue">
	         <td>${emp.empno}</td>
	         <td>${emp.ename}</td>
	         <td>${emp.job}</td>
	         <td>${emp.sal}</td>
	         <td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.jfif"width="30"height="30"></a></td>
	         <td><a href="emp_delete?no=${emp.empno}"onclick="return confirm('Do you want to delete the Employee')">
	                <img src="images/delete.jfif"width="30"height="30"></a></td>
	       </tr>
	     </c:forEach>
	  </table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align=center">Employees Not Found</h1>
	</c:otherwise>
</c:choose>
<br><br>

<h3 style="color:green;text-align:center">${resultMsg}</h3>

<center>
  <a href="emp_add"><img src="images/add.jfif"width="50"height="60">Add Employee</a>&nbsp;&nbsp;&nbsp;
  <a href="./"><img src="images/home.jfif"width="60"height="70">Home</a>
</center>

