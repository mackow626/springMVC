<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SG0953457
  Date: 2018-06-01
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Klient</title>

    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>

<form:form action="zapisKlienta" modelAttribute="klient">


    imie <form:input path="imie1"/>

    <br><br>

    nazwisko (*) <form:input path="nazwisko1"/>
    <form:errors path="nazwisko1" cssClass="error" />


    <br><br>

    <input type="submit" value="Zapisz">


</form:form>

</body>
</html>
