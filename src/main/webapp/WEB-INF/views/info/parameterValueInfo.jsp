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
            <h2 class="list-group-item-text">Parameter Value</h2>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Parameter ID</h4>
            <p class="list-group-item-text">${parameterValue.id}</p>
        </a>
        <a href="/individualTask/${parameterValue.individualTaskId}" class="list-group-item">
            <h4 class="list-group-item-heading">Individual Task Id</h4>
            <p class="list-group-item-text">${parameterValue.individualTaskId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Parameter Id</h4>
            <p class="list-group-item-text">${parameterValue.parameterId}</p>
        </a>
        <a class="list-group-item">
            <h4 class="list-group-item-heading">Parameter Value</h4>
            <p class="list-group-item-text">${parameterValue.parameterValue}</p>
        </a>
    </div>
</div>