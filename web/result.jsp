<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tretich
  Date: 25.05.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<jsp:useBean id="result" class="dto.Result" scope="request"/>
    Количество значений функции ${result.numberOfY}<br>
    Значение функции в 0 точке ${result.y[0]}<br>
    Значение функции в 180 точке ${result.y[180]}<br>
    Значение функции в 240 точке ${result.y[240]}<br>
    Минимальное значение функции ${result.y[result.min]} при аргументе ${result.x[result.min]}<br>
    Максимальное значение функции ${result.y[result.max]} при аргументе ${result.x[result.max]}<br>
    Сумма значений функции ${result.sum}<br>
    Среднее арифметическое значений функции ${result.avg}<br><br><br>

<h3>Введите новые исходные данные</h3>
<form method="get" action="result.html">

    Введите начало интервала <input type="text" name="interval_start"> <br>
    Введите конец интервала  <input type="text" name="interval_end">  <br>
    Введите дельту           <input type="text" name="delta">
    <input type="submit" value="Ok">
</form>
<%--<c:out value="${result.numberOfY}"/>--%>


</body>
</html>
