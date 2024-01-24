<%--
  Created by IntelliJ IDEA.
  User: lool
  Date: 06/12/2023
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" class="form-control  p-2 " action="ClientServlet" >
    <table class="p-3 mx-auto w-75 table table-hover">
        <tr>
            <td>Nom :</td>
            <td><input type="text" class="text-center" required name="name"></td>
        </tr>
        <tr>
            <td>Prenom:</td>
            <td><input  type="text" class="text-center"  required name="surname"></td>
        </tr>
        <tr>
            <td>Adresse:</td>
            <td><input type="text" class="text-center"  required name="adresse"></td>
        </tr>
        <tr>
            <td>Societe:</td>
            <td><input type="text" class="text-center"  required name="societe"></td>
        </tr>
    </table>
    <button class="btn btn-outline-secondary m-3" type="submit">AddClient</button>

</form>
</body>
</html>
