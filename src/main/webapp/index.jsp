<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Distance Calculator</title>
</head>

<body>

<h2>Обчислення відстані між двома точками на Землі</h2>

<!-- Форма відправляє дані в Servlet за URL /distance -->
<form action="distance" method="post">

    <!-- Перша точка -->
    Широта 1:
    <input type="text" name="lat1"><br>

    Довгота 1:
    <input type="text" name="lon1"><br><br>

    <!-- Друга точка -->
    Широта 2:
    <input type="text" name="lat2"><br>

    Довгота 2:
    <input type="text" name="lon2"><br><br>

    <!-- Кнопка відправки форми -->
    <input type="submit" value="Розрахувати">

</form>

</body>
</html>