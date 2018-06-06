<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration form </title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
<form:form action="zapisKlienta" modelAttribute="klient">
    <br>
    First Name: <form:input path="imie1" />
    <form:errors path="imie1" cssClass="error"/>
    <br>
    Last Name : <form:input path="nazwisko1" />
    <form:errors path="nazwisko1" cssClass="error"/>
    <br>
    <br>
    Postal code : <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error"/>
    <br>
    <input type="submit" value="submit"/>
</form:form>

</body>
</html>