<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<%
    List<Client> clientList = (List<Client>)request.getAttribute("clients");
    List<Facture> factureList = (List<Facture>)request.getAttribute("factures");
%>
<div class="container-fluid p-3 ">
    <div class="row g-3">
        <div class="col-md-6 text-center">
            <%@include file="WEB-INF/Client/addClient.jsp"%>
        </div>
        <div class="col-md-6 text-center" style="max-height: 45vh ;overflow: auto">
            <%@include file="WEB-INF/Client/clientsList.jsp"%>
        </div>
        <div class="col-md-6 text-center">
            <%@include file="WEB-INF/Facture/addFacture.jsp"%>
        </div>
        <div class="col-md-6 text-center" style="max-height: 45vh ;overflow: auto">
            <%@include file="WEB-INF/Facture/facturesList.jsp"%>
        </div>
    </div>
</div>
</body>
</html>