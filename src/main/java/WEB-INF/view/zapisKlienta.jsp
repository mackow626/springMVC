<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Zapis Klienta</title>
</head>
<body>
Klient is confirmed: ${klient.imie1} ${klient.nazwisko1}
<br>
Kod pocztowy :${klient.postalCode}
<br>
Kod kursu: ${klient.kodKursu}
</body>
</html>
