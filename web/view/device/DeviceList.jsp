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
                    <h1>디바이스 리스트
                        <small>Space Care System</small>
                        <div class="pull-right">
                            <a href="/device/add" class="btn btn-primary" role="button">+</a>
                        </div>
                    </h1>
                </div>
                <table class="table table-striped">
                    <thead class="text-center">
                    <tr>
                        <th>ID</th>
                        <th>디바이스명</th>
                        <th>사용 유저</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="device" items="${devices}">
                    <tr>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary" data-toggle="collapse"
                                    data-target=#${device.deviceId}>${device.deviceId}
                            </button>
                            <div id="${device.deviceId}" class="collapse margin-top">
                                <div class="btn-group-vertical btn-group-sm" id="account-select">
                                    <button class="btn btn-warning" role="button"
                                            onclick="location.href='/sensor/list?deviceId=${device.deviceId}'">SENSOR
                                    </button>
                                    <button class="btn btn-warning" role="button"
                                            onclick="location.href='/actuator/list'">ACTUATOR
                                    </button>
                                    <button class="btn btn-default" role="button"
                                            onclick="location.href='/device/info?deviceId=${device.deviceId}'">INFO
                                    </button>
                                    <button class="btn btn-danger" role="button" value="{{id}}"
                                            onclick="location.href='/device/delete?deviceId=${device.deviceId}'">DELETE
                                    </button>
                                </div>
                            </div>
                        </td>
                        <td>${device.deviceName}</td>
                        <td>${device.userId}</td>
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
