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
    <body>
        <div class="container">
            <h2>Queries</h2>
            <c:forEach items="${sqlQueriesTextList}" var="sqlQuery">
                <br><c:out value="${sqlQuery}" /></br>
            </c:forEach>
        </div>



        <div class="container">
            <h2>Query Arguments</h2>
            <c:forEach items="${argumentsLists}" var="argumentList">
                <c:forEach items="${argumentList}" var="queryArgument">
                        <br><c:out value="${queryArgument.getName()} " /> <c:out value="${queryArgument.getQueryType()}" /></br>
                </c:forEach>
            </c:forEach>
        </div>
    </body>
</div>
</html>
