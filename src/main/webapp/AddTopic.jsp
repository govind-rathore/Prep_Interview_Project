<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>Add Aptitude Topic</h1>

    <form action="addAptitudeTopic" method="post">
        <label for="topicName">Topic Name:</label><br>
        <input type="text" id="topicName" name="topicName" required><br><br>

      

        <button type="submit">Add Topic</button>
    </form>


</body>
</html>