<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:blue;text-align:center">Customer registration Form </h1>


<frm:form  action="register" modelAttribute="cust" >
     <p style="color:red;text-align:center">
       <frm:errors path="*"/>
    </p>  
   <table border="0" bgcolor="cyan" align="center">
       <tr>
         <td> Customer number:: </td>
          <td> <frm:input path="cno"/>  </td>
       </tr>
         <tr>
         <td> Customer Name:: </td>
          <td> <frm:input path="cname" /> </td>
       </tr>
       <tr>
         <td> Customer BillAmount:: </td>
          <td> <frm:input path="billAmt"/>  </td>
       </tr>
        <tr>
         <td> Customer DOB(dd-MM-yyyy):: </td>
          <td> <frm:input path="dob" type="date"/></td>
       </tr>
         <tr>
         <td> Customer DOJ(Joining):: </td>
          <td> <frm:input path="doj" type="date"/></td>
       </tr>
          <tr>
         <td> Customer DOP(purchase):: </td>
          <td> <frm:input path="dop" type="datetime-local"/></td>
       </tr>
          <tr>
         <td> Customer TOB(Time of Birth):: </td>
          <td> <frm:input path="tob" type="time"/></td>
       </tr>
        <tr>
         <td><input type="submit"  value="register"></td>
       </tr>
   </table>

</frm:form> 

