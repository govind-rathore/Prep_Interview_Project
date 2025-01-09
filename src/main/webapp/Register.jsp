<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Register Your Details:</h1>


	<form action="register-user" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="role">Register as:</label>
    <select name="role" id="role" onchange="toggleKeyField()">
        <option value="USER">User</option>
        <option value="ADMIN">Admin</option>
    </select><br><br>

    <div id="admin-key-field" style="display: none;">
        <label for="adminKey">Authorization Key:</label>
        <input type="text" id="adminKey" name="adminKey"><br><br>
    </div>

    <input type="submit" value="Register">
</form>

<script>
function toggleKeyField() {
    const role = document.getElementById("role").value;
    const keyField = document.getElementById("admin-key-field");
    keyField.style.display = role === "ADMIN" ? "block" : "none";
}
</script>





	
	
