<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Attribute Info</title>

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
            <h2 class="list-group-item-text">Attribute</h2>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Attribute ID</h4>
            <p class="list-group-item-text">${attribute.id}</p>
        </a>
        <a href="/object/${attribute.objectId}"  class="list-group-item">
            <h4 class="list-group-item-heading">Object ID</h4>
            <p class="list-group-item-text">${attribute.objectId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Attribute Name</h4>
            <p class="list-group-item-text">${attribute.name}</p>
        </a>
    </div>
</div>


<div class="container">
    <p>Click on the button to show elements that reference to this element.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">More information</button>
    <div id="demo" class="collapse">
        <div class="container">

            <h2>Attribute Values</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Attribute Value Id</th><th>Attribute Value</th>
                </tr>
                <c:forEach items="${attributeValueList}" var="attributeValue">
                    <tr>
                        <td><a href="<spring:url value="/attributeValue/${attributeValue.id}"/>"><c:out value="${attributeValue.id}" /></a></td>
                        <td><c:out value="${attributeValue.attributeValue}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

</body>
</html>