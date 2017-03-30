<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Subject Domain Info</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
    <h1>Info</h1>
    <div class="list-group">
        <a href="#" class="list-group-item active">
            <h4 class="list-group-item-heading">Type</h4>
            <h2 class="list-group-item-text">Attribute Value</h2>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Attribute Value ID</h4>
            <p class="list-group-item-text">${attributeValue.id}</p>
        </a>
        <a href="/attribute/${attributeValue.attributeId}"  class="list-group-item">
            <h4 class="list-group-item-heading">Attribute ID</h4>
            <p class="list-group-item-text">${attributeValue.attributeId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Attribute Value</h4>
            <p class="list-group-item-text">${attributeValue.attributeValue}</p>
        </a>
    </div>
</div>

<div class="container">
    <p>Click on the button to show elements that reference to this element.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">More information</button>
    <div id="demo" class="collapse">

        <div class="container">
            <h2>Object States</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Object Instance Id</th><th>Subject Domain State Id</th>
                </tr>
                <c:forEach items="${objectStateList}" var="objectState">
                    <tr>
                        <td><c:out value="${objectState.objectInstanceId}" /></td>
                        <td><c:out value="${objectState.subjectDonainStateId}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

</body>
</html>