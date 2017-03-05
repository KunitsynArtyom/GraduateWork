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
            <p class="list-group-item-text">Individual Task</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Individual Task ID</h4>
            <p class="list-group-item-text">${individualTask.id}</p>
        </a>
        <a href="/massProblem/${individualTask.massProblemId}" class="list-group-item">
            <h4 class="list-group-item-heading">Mass Problem ID</h4>
            <p class="list-group-item-text">${individualTask.massProblemId}</p>
        </a>
    </div>
</div>