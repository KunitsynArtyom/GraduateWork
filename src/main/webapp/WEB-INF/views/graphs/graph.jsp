<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Graph</title>

    <style type="text/css">
        #network {
            width: 1000px;
            height: 500px;
            border: 2px solid lightgray;
            margin-left: auto;
            margin-right: auto;
        }

        td {
            vertical-align: top;
        }

        table {
            width: 400px;
        }

        #attributes {
            margin-top: 600px;
            margin-left: 200px;
            margin-right: 200px;
            left: 170px;
            bottom: 0;
            right: 0;
        }
    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vis/4.19.1/vis.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/vis/4.19.1/vis.min.css"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        google.charts.load('current', {'packages': ['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['', 'Measure:'],


                <c:forEach items="${definingAttributes}" var="definingAttribute">
                ['${definingAttribute.getAttribute()}', ${definingAttribute.getMeasure()}],
                </c:forEach>
            ]);

            var options = {
                title: '',
                height: 800,
                width: 1500,
                legend: {position: 'none'},
                chart: {
                    title: 'Attribute Measures:',
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

            var chart = new google.charts.Bar(document.getElementById('top_x_div'));
            chart.draw(data, options);
        }
        ;
    </script>

</head>

<jsp:include page="../fragments/header.jsp"></jsp:include>

<body>

<div id="network">
    <div class="vis-network" tabindex="900"
         style="position: relative; overflow: hidden; touch-action: pan-y; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;">
        <canvas width="900" height="360" style="position: relative; touch-action: none; user-select: none;
         -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); width: 100%; height: 100%;"></canvas>
    </div>

    <script>

        var nodes = [
            <c:forEach items="${vertexList}" var="vertex">
            {id: '${vertex}', label: '${vertex.toString()}'},
            </c:forEach>
        ];

        var edges = [
            <c:forEach items="${vertexConnectionList}" var="vertexConnection">
            {from: '${vertexConnection.getParent()}', to: '${vertexConnection.getChild()}', arrows: 'to'},
            </c:forEach>
        ];

        var data = {
            nodes: nodes,
            edges: edges
        };

        var container = document.getElementById('network');
        var options = {
            layout: {
                hierarchical: {
                    direction: "UD",
                    sortMethod: "directed"
                }
            },
            interaction: {dragNodes: false},
            physics: {
                enabled: false
            },
            configure: {
                filter: function (option, path) {
                    if (path.indexOf('hierarchical') !== -1) {
                        return true;
                    }
                    return false;
                },
                showButton: false
            }
        };
        var network = new vis.Network(container, data, options);

    </script>
</div>
</body>

<body>
<div id="attributes">
    <table class="table table-hover table-bordered">
        <body>
        <tr>
            <th>Attribute</th>
            <th>Measure</th>
        </tr>
        <c:forEach items="${definingAttributes}" var="definingAttribute">
            <tr>
                <td><c:out value="${definingAttribute.getAttribute()}"/></td>
                <td><c:out value="${definingAttribute.getMeasure()}"/></td>
            </tr>
        </c:forEach>
        </body>
    </table>
</div>
</body>

<body>
<div id="top_x_div" style="width: 900px; height: 500px; margin-left: 200px;"></div>
</body>

</div>

</html>