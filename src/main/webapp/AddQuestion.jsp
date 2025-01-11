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
    Session session2 = HibernateUtil.getSessionFactory().openSession();
    FetchTopicsService topicsService = new FetchTopicsService(session2);
    ArrayList<AptitudeTopic> topiclist = (ArrayList<AptitudeTopic>) topicsService.getTopics();

    session2.close();
    %>




    <form action="add-question" method="post">
        <label for="topicId">Choose a Topic:</label> <select name="topicId" id="topicId">

            <!-- Printing that topics name which are fetched from database -->
            <%
            for (AptitudeTopic topic : topiclist) {
            %>
            <option value="<%=topic.getTopicId()%>"><%=topic.getTopicName()%></option>
            <%
            }
            %>


        </select> <br> <br> <label for="questionText">Question:</label>
        <textarea name="question" id="questionText"></textarea>
        <br> <br> <label for="optionA">Option A:</label> <input type="text" name="optionA" id="optionA"><br>
        <br> <label for="optionB">Option B:</label> <input type="text" name="optionB" id="optionB"> <br>
        <br> <label for="optionC">Option C:</label> <input type="text" name="optionC" id="optionC"><br>
        <br> <label for="optionD">Option D:</label> <input type="text" name="optionD" id="optionD"> <br>
        <br> <label for="correctOption">Correct Option:</label> <select name="correctOption" id="correctOption">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select><br> <br> <label for="solution">Solution:</label>
        <textarea name="solution" id="solution"></textarea>
        <br> <br>

        <button type="submit">Add Question</button>
    </form>



</body>
</html>