<%@ page import="com.example.hiber.entity.Facture" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lool
  Date: 06/12/2023
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="p-0 m-0">
<div class="p-3">
    <table class="w-100">
        <tr>
            <th>Id </th>
            <th>Montant</th>
            <th>Date</th>
            <th>Id client</th>
            <th>Delete</th>
        </tr>
        <%
            for (Facture facture :factureList) {
        %>
        <tr>
            <td><%=facture.getIdFacture()%></td>
            <td><%=facture.getMontant()%></td>
            <td><%=facture.getDateFacture()%></td>
            <td><%=facture.getClient().getIdClient()%></td>            <td><button class="btn btn-danger w-75" onclick="deleteFacture(<%=facture.getIdFacture()%>)" type='button'>x</button></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<script>
    function deleteFacture(factureId) {
        if (confirm("Are you sure you want to delete this facture?")) {
            var servletUrl = 'FactureServlet?idFact=' + factureId;
            console.log(servletUrl);
            fetch(servletUrl, {
                method: 'DELETE'
            }).then(response => {
                if(confirm('Facture deleted successfully')){
                    location.reload();
                }
            });
        }
    }

</script>
</body>
</html>
