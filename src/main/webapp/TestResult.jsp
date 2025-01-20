<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Results</title>
</head>
<body>
    <h1>Test Results</h1>
    <p>
        Total Questions:
        <%=request.getAttribute("totalQuestions")%></p>
    <p>
        Correct Answers:
        <%=request.getAttribute("correctAnswers")%></p>
    <h2>Thank you for taking the test!</h2>
</body>
</html>
