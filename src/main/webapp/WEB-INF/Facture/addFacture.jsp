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
<body  class="p-0 m-0">
<%    String id = request.getParameter("clId"); %>
<form method="post" class="form-control p-3"   action="FactureServlet">
    <table  class="p-3 mx-auto w-75 table table-hover">
        <tr>
            <td>Id Client:</td>
            <td>
                <label>
                    <input class="text-center" type="number"
                            <% if (id != null) {
                                out.println(" disabled value=\"" + Integer.parseInt(id) + "\" ");
                            }
                            %>
                           required name="idClient"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Montant:</td>
            <td><input  type="number" class="text-center" required name="montant"/></td>
        </tr>
        <tr>
            <td>Date facture :</td>
            <td><input type="date" class="w-75 text-center" required name="datefacture"/></td>
        </tr>
        <% if (id != null) { %>
        <input type="hidden" name="clientId" value="<%= Integer.parseInt(id) %>"/>
        <% } %>

    </table>
    <button class="btn btn-outline-secondary m-3" type="submit">AddFacture</button>
</form>

</body>
</html>
