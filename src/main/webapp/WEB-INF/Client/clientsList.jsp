<%@ page import="com.example.hiber.entity.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lool
  Date: 05/12/2023
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="p-3">
    <table class="w-100">
       <tr>
           <th>Id </th>
           <th>Nom</th>
           <th>Prenom</th>
           <th>Adresse</th>
           <th>Societe</th>
           <th>Factures</th>
           <th>Delete</th>

       </tr>
        <%
            for (Client client :clientList) {
        %>
        <tr>
            <td><%=client.getIdClient()%></td>
            <td><%=client.getNomClient()%></td>
            <td><%=client.getPrenomClient()%></td>
            <td><%=client.getAdresse()%></td>
            <td><%=client.getSociete()%></td>
            <td><button class="btn btn-info w-75 text-center" onclick="showFactures(<%=client.getIdClient()%>)" type='button'>show</button></td>
            <td><button class="btn btn-danger w-75" onclick="deleteClient(<%=client.getIdClient()%>)" type='button'>x</button></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td class="" colspan="2">
                <button class="btn btn-outline-secondary w-100 my-2" onclick="reset()">reset</button>
            </td>
        </tr>
    </table>
</div>
<script>
    function deleteClient(clientId) {
        if (confirm("Are you sure you want to delete this client?")) {
            // Assuming your servlet URL is "ClientServlet"
            var servletUrl = 'ClientServlet?id=' + clientId;
            fetch(servletUrl, {
                method: 'DELETE'
            }).then(response => {
                    if(confirm('Client deleted successfully')){
                       location.reload();
                    }
                });
        }
    }
    function showFactures(clientId) {
        location.href='ClientServlet?clId=' + clientId;
    }
    function reset(){
        location.href='ClientServlet';
    }
</script>
</body>
</html>
