<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<script language="JavaScript"  src="js/validation.js"></script>

<link rel="stylesheet"type="text/css"herf="css/style.css">

<h1 style="color:green;text-align:center">Register Employee</h1>
<frm:form modelAttribute="emp" onsubmit="return doValidations(this)">
 <%--  <p style="color:red;text-align:center"><frm:errors path="*"/></p> --%>
    <table align="center" bgcolor="cyan" border="1">
       <tr>
         <td>Employee Name::</td>
         <td><frm:input path="ename"/><frm:errors path="ename"/><span id="enameErr"></span></td>
       </tr>
       <tr>
         <td>Employee Desg::</td>
         <td><frm:input path="job"/><frm:errors path="job"/><span id="jobErr"></span></td>
       </tr>
       <tr>
         <td>Employee Salary::</td>
         <td><frm:input path="sal"/><frm:errors path="sal"/><span id="salErr"></span></td>
       </tr>
        <tr>
          <td><frm:hidden path="vflag"/> </td>
       </tr>
       <tr>  
         <td><input type="submit" value="register"></td>
         <td><input type="reset" value="cancel"></td>
      </tr>
      
    </table>
    
</frm:form>




