<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SUM OF TWO</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
<h2>Super app!</h2>
</div>

<div class="w3-container w3-light-blue">
<h2>Calculate sum of two numbers</h2>
</div>

<p>Your numbers are: ${num1}, ${num2}</p>

<form method="POST">
    <label for="answer">Sum:</label>
    <input id="answer" type="number" name="answer">
    <input type="hidden" name="hash" value=${hash}>
</form>

</body>
</html>