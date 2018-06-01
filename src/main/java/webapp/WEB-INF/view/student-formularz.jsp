<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SG0953457
  Date: 2018-06-01
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>studentformularz</title>
</head>
<body>

<form:form action="zapisany" modelAttribute="student">

    First name <form:input path="imie"/>

    <br><br>

    First nazwisko <form:input path="nazwisko"/>

    <br><br>

    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>

    <br><br>

    <form:radiobuttons  path="programowanie" items="${student.programingOptions}"/>


    
    <input type="submit" value="Zapisz">

</form:form>

</body>
</html>
