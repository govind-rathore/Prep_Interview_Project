<%@page import="com.prepinterview.entity.TestQuestion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>
</head>
<body>
    <h1>Test Page</h1>
    <h2>Questions for Selected Topic</h2>
    <form method="post" action="EvaluateTestServlet">
        <%
        // Get the list of questions from the request attribute
        List<TestQuestion> questions = (List<TestQuestion>) request.getAttribute("qlist");

        if (questions != null && !questions.isEmpty()) {
        %>
        <%
        for (TestQuestion question : questions) {
        %>
        <div style="margin-bottom: 20px;">
            <h3>
                Question:
                <%=question.getQuestion()%></h3>
            <h5>
                Mark:
                <%=question.getMarks()%></h5>

            <!-- Display the options -->
            <div>
                <input type="radio" name="answer-<%=question.getQuestionId()%>" value="A"> <strong>A:</strong>
                <%=question.getOptionA()%>
            </div>
            <div>
                <input type="radio" name="answer-<%=question.getQuestionId()%>" value="B"> <strong>B:</strong>
                <%=question.getOptionB()%>
            </div>
            <div>
                <input type="radio" name="answer-<%=question.getQuestionId()%>" value="C"> <strong>C:</strong>
                <%=question.getOptionC()%>
            </div>
            <div>
                <input type="radio" name="answer-<%=question.getQuestionId()%>" value="D"> <strong>D:</strong>
                <%=question.getOptionD()%>
            </div>

            <!-- Hidden field to pass the correct answer -->
            <input type="hidden" name="correct-<%=question.getQuestionId()%>"
                value="<%=question.getCorrectOption()%>">
        </div>
        <%
        }
        %>
        <button type="submit">Submit</button>
        <%
        } else {
        %>
        <p>No questions available for this topic.</p>
        <%
        }
        %>
    </form>
</body>
</html>
