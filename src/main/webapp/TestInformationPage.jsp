<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


    <h1>Welcome to Test Page</h1>



    <h3>
        Test Topic:
        <%=request.getParameter("topicName")%>
    </h3>


    <p>Questions: 20 Time: 30 minutes Marks: 20 Marks</p>



    <button
        onclick="window.location.href='topic-wise-test?topicId=<%=request.getParameter("topicId")%>&userId=<%=request.getParameter("userId")%>'">Start
        Test</button>







</body>
</html>