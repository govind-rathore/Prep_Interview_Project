<%@page import="com.prepinterview.entity.AptitudeTopic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.prepinterview.service.FetchTopicsService"%>
<%@page import="com.prepinterview.config.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>Add Question</h1>



    <!-- Fetching Topics name from DataBase -->
    <%
    Session session3 = HibernateUtil.getSessionFactory().openSession();
    FetchTopicsService topicsService = new FetchTopicsService(session3);
    ArrayList<AptitudeTopic> topiclist = (ArrayList<AptitudeTopic>) topicsService.getTopics();

    session3.close();
    %>




    <form action="add-formulas" method="post">
        <label for="topicId">Choose a Topic:</label> <select name="topicId" id="topicId">

            <!-- Printing that topics name which are fetched from database -->
            <%
            for (AptitudeTopic topic : topiclist) {
            %>
            <option value="<%=topic.getTopicId()%>"><%=topic.getTopicName()%></option>
            <%
            }
            %>


        </select> <br> <br> <label for="formulaText">Formulas:</label>
        <textarea name="formula" id="formulaText"></textarea>


        <button type="submit">Add Question</button>
    </form>



</body>
</html>