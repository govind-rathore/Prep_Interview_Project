<%@page import="com.prepinterview.entity.AptitudeTopic"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




    <h1>Select topic you want to add test questions</h1>

    <%
    List<AptitudeTopic> topics = (List<AptitudeTopic>) request.getAttribute("topics");

    for (AptitudeTopic topic : topics) {
    %>
    <h3>
        <a href="AddTestQuestion.jsp?topicId=<%=topic.getTopicId()%>&topicName=<%=topic.getTopicName()%>"> <%=topic.getTopicName()%>
        </a>
    </h3>


    <%
    }
    %>




</body>
</html>