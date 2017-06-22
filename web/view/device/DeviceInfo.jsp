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
                <article class="container col-md-6" style="margin: 0;">
                    <div class="page-header">
                        <h1>디바이스 정보
                            <small>Space Care System</small>
                        </h1>
                    </div>
                    <div>
                        <form name="check" id="register_form">
                            <div>
                                <input type="hidden" name="deviceId" value="${device.deviceId}">
                            </div>
                            <div class="form-group">
                                <label for="deviceName">디바이스명</label>
                                <input type="text" class="form-control" name="deviceName" id="deviceName" disabled
                                       value="${device.deviceName}">
                            </div>
                            <div class="form-group">
                                <label for="userId">사용 유저</label>
                                <input type="text" class="form-control" name="userId" id="userId" disabled
                                       value="${device.userId}">
                            </div>
                            <div class="form-group text-center"> 
                                <button type="button" class="btn btn-warning" onclick="location.href='/device/list'">
                                    돌아가기
                                    <i  class="fafa-timesspaceLeft"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </article>
            </div>
        </div>
    </div>
</div>
</body>
</html>
