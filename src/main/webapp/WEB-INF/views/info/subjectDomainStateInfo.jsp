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
<br>

<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
    <h1>Info</h1>
    <div class="list-group">
        <a href="#" class="list-group-item active">
            <h4 class="list-group-item-heading">Type</h4>
            <h2 class="list-group-item-text">Subject Domain State</h2>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Subject Domain State Id</h4>
            <p class="list-group-item-text">${subjectDomainState.id}</p>
        </a>
        <a href="/subjectDomain/${subjectDomainState.subjectDomainId}"  class="list-group-item">
            <h4 class="list-group-item-heading">Subject Domain Id</h4>
            <p class="list-group-item-text">${subjectDomainState.subjectDomainId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Time Stamp</h4>
            <p class="list-group-item-text">${subjectDomainState.timeStamp}</p>
        </a>
    </div>
</div>

<div class="container">
    <p>Click on the button to show elements that reference to this element.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">More information</button>
    <div id="demo" class="collapse">
        <div class="container">

            <h2>Connection States</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Connection State Id</th><th>Connection Instance Id</th> <th>Connection Connection State Name Id</th>
                </tr>
                <c:forEach items="${connectionStateList}" var="connectionState">
                    <tr>
                        <td><a href="<spring:url value="/connectionState/${connectionState.id}"/>"><c:out value="${connectionState.id}" /></a></td>
                        <td><c:out value="${connectionState.connectionInstanceId}" /></td>
                        <td><c:out value="${connectionState.name}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

