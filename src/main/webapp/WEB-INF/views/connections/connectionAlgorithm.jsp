<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Connection Algorithm</title>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>


    <jsp:include page="../fragments/header.jsp"></jsp:include>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['', ''],

                <c:forEach items="${stabilityMap}" var="entry">
                ['${entry.key}', ${entry.value}],
                </c:forEach>
            ]);

            var options = {
                title: '',
                width: 800,
                height: 300,
                legend: {position: 'none'},
                chart: {
                    title: 'Stability:',
                    subtitle: ''
                },
                bars: 'horizontal',
                axes: {
                    x: {
                        0: {side: '', label: ''}
                    }
                },
                bar: {groupWidth: "90%"}
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div1'));
            chart.draw(data, options);
        }
        ;
    </script>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['', ''],

                <c:forEach items="${inevitabilityMap}" var="entry">
                ['${entry.key}', ${entry.value}],
                </c:forEach>
            ]);

            var options = {
                title: '',
                width: 800,
                height: 300,
                legend: {position: 'none'},
                chart: {
                    title: 'Inevitability:',
                    subtitle: ''
                },
                bars: 'horizontal',
                axes: {
                    x: {
                        0: {side: '', label: ''}
                    }
                },
                bar: {groupWidth: "90%"}
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div2'));
            chart.draw(data, options);
        }
        ;
    </script>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['', ''],

                <c:forEach items="${createProbabilityMap}" var="entry">
                <c:forEach items="${entry.value}" var="innerEntry">
                ['${entry.key} / ${innerEntry.key}', ${innerEntry.value}],
                </c:forEach>
                </c:forEach>
            ]);

            var options = {
                title: '',
                width: 800,
                height: 400,
                legend: {position: 'none'},
                chart: {
                    title: 'Create Probability:',
                    subtitle: ''
                },
                bars: 'horizontal',
                axes: {
                    x: {
                        0: {side: 'top', label: ''}
                    }
                },
                bar: {groupWidth: "90%"}
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div3'));
            chart.draw(data, options);
        }
        ;
    </script>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['', ''],

                <c:forEach items="${destroyProbabilityMap}" var="entry">
                <c:forEach items="${entry.value}" var="innerEntry">
                ['${entry.key} / ${innerEntry.key}', ${innerEntry.value}],
                </c:forEach>
                </c:forEach>
            ]);

            var options = {
                title: '',
                width: 800,
                height: 400,
                legend: {position: 'none'},
                chart: {
                    title: 'Destroy Probability:',
                    subtitle: ''
                },
                bars: 'horizontal',
                axes: {
                    x: {
                        0: {side: 'top', label: ''}
                    }
                },
                bar: {groupWidth: "90%"}
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div4'));
            chart.draw(data, options);
        }
        ;
    </script>

<body>

<div class="container">
    <p>Click on the button to show connection stability.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo1">Stability</button>
    <div id="demo1" class="collapse">
        <h2>Stability</h2>
        <table class="table table-hover table-bordered">
            <body>
            <tr>
                <th>Connection</th>
                <th>Value</th>
            </tr>
            <c:forEach items="${stabilityMap}" var="entry">
                <tr>
                    <td><c:out value="${entry.key}"/></td>
                    <td><c:out value="${entry.value}"/></td>
                </tr>
            </c:forEach>
            </body>
        </table>
    </div>
</div>

<body>
<div id="top_x_div1" style="width: 900px; height: 300px;"></div>
</body>

<div class="container">
    <p>Click on the button to show connection inevitability.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo2">Inevitability</button>
    <div id="demo2" class="collapse">
        <h2>Inevitability</h2>
        <table class="table table-hover table-bordered">
            <body>
            <tr>
                <th>Connection</th>
                <th>Value</th>
            </tr>
            <c:forEach items="${inevitabilityMap}" var="entry">
                <tr>
                    <td><c:out value="${entry.key}"/></td>
                    <td><c:out value="${entry.value}"/></td>
                </tr>
            </c:forEach>
            </body>
        </table>
    </div>
</div>

<body>
<div id="top_x_div2" style="width: 900px; height: 300px;"></div>
</body>

<div class="container">
    <p>Click on the button to show connection create probability.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo3">Create Probability</button>
    <div id="demo3" class="collapse">

        <h2>CreateProbability</h2>
        <table class="table table-hover table-bordered">
            <body>
            <tr>
                <th>Mass Problem</th>
                <th>Connection</th>
                <th>Value</th>
            </tr>
            <c:forEach items="${createProbabilityMap}" var="entry">
                <c:forEach items="${entry.value}" var="innerEntry">
                    <tr>
                        <td><c:out value="${entry.key}"/></td>
                        <td><c:out value="${innerEntry.key}"/></td>
                        <td><c:out value="${innerEntry.value}"/></td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </body>
        </table>
    </div>
</div>

<body>
<div id="top_x_div3" style="width: 900px; height: 400px;"></div>
</body>

<div class="container">
    <p>Click on the button to show connection create probability.</p>
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo4">Destroy Probability</button>
    <div id="demo4" class="collapse">

        <h2>DestroyProbability</h2>
        <table class="table table-hover table-bordered">
            <body>
            <tr>
                <th>Mass Problem</th>
                <th>Connection</th>
                <th>Value</th>
            </tr>
            <c:forEach items="${destroyProbabilityMap}" var="entry">
                <c:forEach items="${entry.value}" var="innerEntry">
                    <tr>
                        <td><c:out value="${entry.key}"/></td>
                        <td><c:out value="${innerEntry.key}"/></td>
                        <td><c:out value="${innerEntry.value}"/></td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </body>
        </table>
    </div>
</div>

<body>
<div id="top_x_div4" style="width: 900px; height: 400px;"></div>
</body>

</body>
</head>
</body>
</html>