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
    <meta http-equiv="refresh" content="1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link href="/public/css/bootstrap.min.css" rel="stylesheet">
    <script src="/public/js/chartist.min.js"></script>
    <link href="/public/js/chartist.min.css" rel="stylesheet" type="text/css"/>
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
                    <h1>데이터 그래프
                        <small>Space Care System</small>
                    </h1>
                </div>
                <div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="my-chart" id="my-chart">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
  var options = {
    height: 500,
    high: 35,
    low: -35
  };

  var data = {
    series: [
      []
    ]
  };

  var responsiveOptions = [
    ['screen and (min-width: 641px) and (max-width: 1024px)', {
      showPoint: false,
      axisX: {
        labelInterpolationFnc: function (value) {
          return 'Week ' + value;
        }
      }
    }],
    ['screen and (max-width: 640px)', {
      showLine: false,
      axisX: {
        labelInterpolationFnc: function (value) {
          return 'W' + value;
        }
      }
    }]
  ];

</script>
<c:forEach var="sensing" items="${sensings}">
    <script>
      data.series[0].push(${sensing.sensingValue});
    </script>
</c:forEach>

<script>
    console.log(data.series[0]);
  new Chartist.Line('#my-chart', data, options, responsiveOptions);
</script>
</body>
</html>
