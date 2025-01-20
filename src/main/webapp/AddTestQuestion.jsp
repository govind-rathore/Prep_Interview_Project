<%@page import="com.prepinterview.entity.AptitudeTopic"%>
<%@page import="com.prepinterview.entity.AptitudeQuestion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Test Question</title>
</head>
<body>

    <h1>Add Test Question</h1>

    <%
    String topicIdParam = request.getParameter("topicId");
    if (topicIdParam == null || topicIdParam.isEmpty()) {
        out.println("<h3>Topic ID is missing. Please select a topic first.</h3>");
        return;
    }

    int topicId = Integer.parseInt(topicIdParam);
    String topicName = request.getParameter("topicName");
    if (topicName == null || topicName.isEmpty()) {
        topicName = "Unknown Topic";
    }
    %>

    <form action="add-test-question" method="post">
        <label for="topicName">Topic:</label> 
        <input type="text" value="<%=topicName%>" name="topicName" id="topicName" readonly="readonly"><br>
        <input type="text" value="<%=topicId%>" name="topicId" readonly="readonly"> <br>
        
        <label for="questionText">Question:</label>
        <textarea name="question" id="questionText" required></textarea><br>
        
        <label for="optionA">Option A:</label> <input type="text" name="optionA" id="optionA" required><br>
        <label for="optionB">Option B:</label> <input type="text" name="optionB" id="optionB" required><br>
        <label for="optionC">Option C:</label> <input type="text" name="optionC" id="optionC" required><br>
        <label for="optionD">Option D:</label> <input type="text" name="optionD" id="optionD" required><br>
        
        <label for="correctOption">Correct Option:</label> 
        <select name="correctOption" id="correctOption">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select><br>
        
        <label for="marks">Marks:</label> 
        <input type="number" name="marks" id="marks" required min="1"><br>
        
        <label for="solution">Solution:</label>
        <textarea name="solution" id="solution" required></textarea><br>
        
        <button type="submit">Add Question</button>
    </form>

</body>
</html>
