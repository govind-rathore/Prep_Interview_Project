<%@page import="com.prepinterview.entity.AptitudeQuestion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
// Get the list of questions from the request attribute
List<AptitudeQuestion> questions = (List<AptitudeQuestion>) request.getAttribute("qlist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic Questions</title>
<script>
        // Function to check if the selected option is correct
        function checkAnswer(questionId, correctAnswer, selectedOption) {
            const resultElement = document.getElementById("result-" + questionId);
            if (correctAnswer === selectedOption) {
                resultElement.innerHTML = "<span style='color: green;'>Correct!</span>";
            } else {
                resultElement.innerHTML = "<span style='color: red;'>Wrong!</span>";
            }
        }

        // Show the explanation when the user clicks 'Show Explanation'
        function showExplanation(questionId, explanation) {
            const explanationElement = document.getElementById("explanation-" + questionId);
            explanationElement.innerText = explanation;
            if( explanationElement.style.display==='none'){
            	 explanationElement.style.display = "block";
            }else{
            	 explanationElement.style.display = "none";
            }
            
           
            
        }
    </script>
</head>
<body>
    <h1>Questions for Selected Topic</h1>
    <div>
        <%
        if (questions != null && !questions.isEmpty()) {
        %>
        <%
        for (AptitudeQuestion question : questions) {
        %>
        <div style="margin-bottom: 20px;">
            <h3>
                Question:
                <%=question.getQuestion()%></h3>

            <!-- Display the options -->
            <div>
                <input type="radio" name="question-<%=question.getQuestionId()%>" value="A"
                    onclick="checkAnswer(<%=question.getQuestionId()%>, 
                             '<%=String.valueOf(question.getCorrectOption()).replace("'", "\\'")%>', 
                             'A')">
                <strong>A:</strong>
                <%=question.getOptionA()%>
            </div>
            <div>
                <input type="radio" name="question-<%=question.getQuestionId()%>" value="B"
                    onclick="checkAnswer(<%=question.getQuestionId()%>, 
                             '<%=String.valueOf(question.getCorrectOption()).replace("'", "\\'")%>', 
                             'B')">
                <strong>B:</strong>
                <%=question.getOptionB()%>
            </div>
            <div>
                <input type="radio" name="question-<%=question.getQuestionId()%>" value="C"
                    onclick="checkAnswer(<%=question.getQuestionId()%>, 
                             '<%=String.valueOf(question.getCorrectOption()).replace("'", "\\'")%>', 
                             'C')">
                <strong>C:</strong>
                <%=question.getOptionC()%>
            </div>
            <div>
                <input type="radio" name="question-<%=question.getQuestionId()%>" value="D"
                    onclick="checkAnswer(<%=question.getQuestionId()%>, 
                             '<%=String.valueOf(question.getCorrectOption()).replace("'", "\\'")%>', 
                             'D')">
                <strong>D:</strong>
                <%=question.getOptionD()%>
            </div>

            <!-- Feedback area -->
            <div id="result-<%=question.getQuestionId()%>" style="margin-top: 10px;"></div>

            <!-- Show Explanation button -->
            <button id="<%=question.getQuestionId()%> %>"
                onclick="showExplanation(<%=question.getQuestionId()%>, `<%=question.getSolution()%>`)">Show
                Explanation</button>
            <div id="explanation-<%=question.getQuestionId()%>" style="display: none; margin-top: 10px; color: blue;"></div>
        </div>


        <%
        }
        %>
        <%
        } else {
        %>
        <p>No questions available for this topic.</p>
        <%
        }
        %>
    </div>
</body>
</html>
