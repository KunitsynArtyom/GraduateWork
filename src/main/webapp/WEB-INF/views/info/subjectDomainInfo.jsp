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
            <p class="list-group-item-text">Subject Domain</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Subject Domain ID</h4>
            <p class="list-group-item-text">${subjectDomain.id}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Subject Domain Name</h4>
            <p class="list-group-item-text">${subjectDomain.name}</p>
        </a>
    </div>
</div>

<div class="container">
    <p>Click on the button to show elements that reference on current element.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">More information</button>
    <div id="demo" class="collapse">
        <div class="container">
            <h2>Subject Domain States</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Subject Domain State Id</th><th>Time Stamp</th>
                </tr>
                <c:forEach items="${subjectDomainStateList}" var="subjectDomainState">
                    <tr>
                        <td><c:out value="${subjectDomainState.id}" /></td>
                        <td><c:out value="${subjectDomainState.timeStamp}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>

            <h2>Objects</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Object Id</th><th>Object Instance ID</th><th>Object Name</th>
                </tr>
                <c:forEach items="${objList}" var="obj">
                    <tr>
                        <td><a href="<spring:url value="/object/${obj.id}"/>"><c:out value="${obj.id}" /></a></td>
                        <td><a href="<spring:url value="/objectInstance/${obj.objectInstanceId}"/>"><c:out value="${obj.objectInstanceId}" /></a></td>
                        <td><c:out value="${obj.name}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>

            <h2>Connections</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Connection Id</th><th>Connection Name</th>
                </tr>
                <c:forEach items="${connectionList}" var="connection">
                    <tr>
                        <td><c:out value="${connection.id}" /></td>
                        <td><c:out value="${connection.name}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>

            <h2>Mass Problems</h2>
            <table class="table table-hover table-bordered">
                <body>
                <tr>
                    <th>Mass Problem Id</th><th>Mass Problem Name</th>
                </tr>
                <c:forEach items="${massProblemList}" var="massProblem">
                    <tr>
                        <td><a href="<spring:url value="/massProblem/${massProblem.id}"/>"><c:out value="${massProblem.id}" /></a></td>
                        <td><c:out value="${massProblem.name}" /></td>
                    </tr>
                </c:forEach>
                </body>
            </table>
        </div>
    </div>
</div>

</body>
</html>