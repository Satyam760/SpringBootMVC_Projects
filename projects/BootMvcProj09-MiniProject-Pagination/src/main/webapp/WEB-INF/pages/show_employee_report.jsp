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
</center>  --%>
 
 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
 
 <div class="container">
<c:choose>
	<c:when test="${!empty result.getContent()}">
	  <h1 style="color:brown;text-align:center">Employees Report</h1>
	  <table border="1" class="table">
	     <tr class="table-danger">
	       <th>Employee no</th>
	       <th>Employee name</th>
	       <th>job</th>
	       <th>salary</th>
	       <th>operation</th>
	      </tr>
	     <c:forEach var="emp" items="${result.getContent()}">
	       <tr class="table-success">
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
	  
	  <p style="text-align:center">
	  <c:if test="${result.hasPrevious()}">
	    <a href="report?page=${result.getPageable().getPageNumber()-1}">previous</a> &nbsp;&nbsp;
	  </c:if>
	  
	  <c:if test="${!result.isFirst()}">
	    <a href="report?page=0">first</a> &nbsp;&nbsp;
	  </c:if>
	  
	     <c:forEach var="i" begin="1" end="${result.getTotalPages() }" step="1">
	     [<a href="report?page=${i-1}">${i}</a>] &nbsp;&nbsp;
	     </c:forEach>
	  
	   <c:if test="${!result.isLast()}">
	    <a href="report?page=${result.getTotalPages()-1}">last</a> &nbsp;&nbsp;
	  </c:if>
	  
	  <c:if test="${result.hasNext()}">
	    <a href="report?page=${result.getPageable().getPageNumber()+1}">next</a> &nbsp;&nbsp;
	  </c:if> 
	  </p>
	  
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align=center">Employees Not Found</h1>
	</c:otherwise>
 </c:choose>

       <c:if test="${!empty resultMsg}">
	    <h3 style="color:green;text-align:center">${resultMsg}</h3>
	  </c:if>

<br><br>

 <hr>
  <a href="emp_add"><img src="images/add.jfif"width="50"height="60">Add Employee</a>
  <hr>
  <a href="./"><img src="images/home.jfif"width="60"height="70">Home</a>
 
</div>
 
 
 
 
