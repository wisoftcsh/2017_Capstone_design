<%--
  Created by IntelliJ IDEA.
  User: choiseonho
  Date: 2017. 5. 29.
  Time: PM 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Space Care System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link href="/public/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/public/css/dashboard.css" rel="stylesheet">
    <script src="/public/js/ie-emulation-modes-warning.js"></script>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="/Navi.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="table-responsive">
                <div class="page-header">
                    <h1>센서 리스트
                        <small>Space Care System</small>
                        <div class="pull-right">
                            <a href="/sensor/add" class="btn btn-primary" role="button">+</a>
                        </div>
                    </h1>
                </div>
                <table class="table table-striped">
                    <thead class="text-center">
                    <tr>
                        <th>ID</th>
                        <th>센서명</th>
                        <th>디바이스명</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sensor" items="${sensors}">
                        <tr>
                            <td>
                                <button type="button" class="btn btn-sm btn-primary" data-toggle="collapse"
                                        data-target=#${sensor.sensorId}>${sensor.sensorId}
                                </button>
                                <div id="${sensor.sensorId}" class="collapse margin-top">
                                    <div class="btn-group-vertical btn-group-sm" id="account-select">
                                        <button class="btn btn-warning" role="button"
                                                onclick="location.href='/sensing/list?sensorId=${sensor.sensorId}'">GRAPH
                                        </button>
                                        <button class="btn btn-default" role="button"
                                                onclick="location.href='/sensor/info?sensorId=${sensor.sensorId}'">INFO
                                        </button>
                                        <button class="btn btn-danger" role="button" value="{{id}}"
                                                onclick="location.href='/sensor/delete?sensorId=${sensor.sensorId}'">
                                            DELETE
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td>${sensor.sensorName}</td>
                            <td>${device.deviceName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
