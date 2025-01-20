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

    <h1>All Aptitude Topics</h1>

    <%
    List<AptitudeTopic> topics = (List<AptitudeTopic>) request.getAttribute("topics");

    for (AptitudeTopic topic : topics) {
    %>
    <h3>
        <%=topic.getTopicName()%>
    </h3>
    <button onclick="window.location.href='topicwise-formula?topicId=<%=topic.getTopicId()%>'">Formulas</button>
    <button onclick="window.location.href='topicwise-question?topicId=<%=topic.getTopicId()%>'">Prepare</button>
    <button onclick="window.location.href='Login.jsp?topicId=<%=topic.getTopicId()%>&topicName=<%=topic.getTopicName()%>'">Test</button>


    <%
    }
    %>

</body>
</html>