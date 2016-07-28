<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${title}</title>
   <script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<body>
<h2>${title}</h2>
<br/>

       <div id="registrationForm" >
       <table border="0" cellspacing="5" cellpadding="3">
       <tr>
                   <th> UserId </th>
                   <td><input type="text" id="userId" name="userId" placeholder="UserId"  /></td>
              </tr>
       <tr>
            <th> EmailId </th>
            <td><input type="text" id="email" name="email" placeholder="EmailId"  /></td>
       </tr>
       <tr>
            <th> FirstName </th>
            <td><input type="text" id="firstName" name="firstName" placeholder="FirstName"  /></td>
       </tr>
       <tr>
            <th> LastName   </th>
            <td><input type="text" id="lastName" name="lastName" placeholder="LastName"  /></td>
       </tr>
       <tr>
            <th> Phone Number </th>
            <td><input type="text" id="phoneno" name="phoneno" placeholder="Phone Number"  /></td>
       </tr>
       <tr>
            <th> Password  </th>
            <td><input type="password" id="password" name="password" placeholder="Password" /></td>
       </tr>
       <tr>
            <th> Confirm Password </th>
            <td><input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" /></td>
       </tr>
       <tr>
            <th>
                <input type="hidden" id="socialProvider" name="socialProvider" value="NONE" />
                <input type="submit" id="doRegister" onclick="post()">
            </th>
       </tr>
       </table>
       </div>
	<script>
        post(){
            var person = {
                        userId: $("##registrationForm-userId").val(),
                        email:$("##registrationForm-email").val(),
                        firstName:$("##registrationForm-firstName").val(),
                        lastName: $("##registrationForm-lastName").val(),
                        phoneno:$("##registrationForm-phoneno").val(),
                        password: $("##registrationForm-password").val(),
                        socialProvider:$("##registrationForm-socialProvider").val()
                    }


            $.ajax({
              type: "post",
              url: '/services/user/register',
              data: person,
              dataType: 'json',
              contentType: "application/json; charset=utf-8",
              success: function () {
                alert('success');
              }
            });

        }

</script>
</body>
</html>