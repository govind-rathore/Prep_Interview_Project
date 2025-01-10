<%@page import="com.prepinterview.entity.AptitudeQuestion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%
    List<AptitudeQuestion> qlist = (List<AptitudeQuestion>) request.getAttribute("qlist");

    for (AptitudeQuestion qObject : qlist) {
    %>

    <%=qObject.getQuestion()%><br>
    <%=qObject.getOptionA()%><br>
    <%=qObject.getOptionB()%><br>
    <%=qObject.getOptionC()%><br>
    <%=qObject.getOptionD()%>

    <%
    }
    %>


</body>
</html>