<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <style>
        .text {
            text-align: center;
        }
    </style>

    <style>
        mark {
            background: #ffec82;
            padding: 0 3px;
            border: 1px dashed #333;
        }
    </style>

</head>
<body>

<jsp:include page="../views/fragments/header.jsp"></jsp:include>

<div class="text">
    <H2>The subject domain can be represented as a tuple consisting of three sets of elements
        <mark>(E,V,P)</mark>
        <div class="container">
            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo1">Show Info</button>
            <div id="demo1" class="collapse">
                <H3>
                    The subject area is part of the real world described according to established criteria
                    or it can be the knowledge used to indicate the scope of any human activity.
                </H3>
            </div>
        </div>
        <mark>E</mark>
        is the set of objects of the SD
        <div class="container">
            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo2">Show Info</button>
            <div id="demo2" class="collapse">
                <H3>
                    Objects, as the basic forming elements of any SD, are the projections of universal entities.
                    Objects have explicitly specified behavior, so changing the state of any entity can lead to a change
                    in the state of the entire SD to which it belongs.
                </H3>
            </div>
        </div>
        <mark>V</mark>
        is the set of connections between the objects
        <div class="container">
            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo3">Show Info</button>
            <div id="demo3" class="collapse">
                <H3>
                    Connections are the second fundamental elements of the SD, they form a physical and information
                    structure between the objects.
                    For example, the same set of objects can describe several different SDs, having a different set of
                    connections.
                    Any relationship is characterized by its stability and inevitability.
                    Stability is responsible for the fundamental nature of the properties of the SD.
                    Inevitability determines the probability of occurrence of a specific connection instance at the next
                    iteration.
                </H3>
            </div>
        </div>
        <mark>P</mark>
        is the set of mass problems

        <div class="container">
            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo4">Show Info</button>
            <div id="demo4" class="collapse">
                <H3>
                    Mass problems are the third fundamental components of the SD.
                    The mass problem is a certain pattern of the task imposed on the SD.
                    At the most mass problem there is an infinite number of decisions that is caused by its level of
                    abstraction.
                    But when a mass problem has certain coefficients, it becomes an individual task - a task that can be
                    solved only over a certain part of the objects and links of the SD.
                </H3>
            </div>
        </div>
    </H2>
</div>


<%--<div class="container">--%>
<%--<img src= "<c:url value="/resources/images/404.png"></c:url>" />--%>
<%--</div>--%>
</body>
</html>