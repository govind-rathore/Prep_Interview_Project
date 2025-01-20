<%@page import="com.prepinterview.entity.User"%>
<%@page import="com.prepinterview.entity.SaveResult"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>



    
  

    <div class="bg-white dark:bg-gray-800 ">
        <div class="lg:flex lg:items-center lg:justify-between w-full mx-auto py-12 px-4 sm:px-6 lg:py-16 lg:px-8 z-20">
            <h2 class="text-3xl font-extrabold text-black dark:text-white sm:text-4xl">
                <span class="block"> Dashboard </span> <span> Welcome <%=request.getAttribute("userName")%>
                </span>


            </h2>

        </div>
    </div>


    <%--     <h1>
        Welcome
        <%=request.getAttribute("userName")%>
    </h1>

    <h3>
        Email :
        <%=request.getAttribute("email")%>
    </h3>

    <h2>My Test</h2>  --%>

    <%
    List<SaveResult> resultList = (List<SaveResult>) request.getAttribute("resultList");
    
    
    %>


    <div class="w-1/2 max-w-4xl mx-auto bg-white shadow-lg rounded-2xl dark:bg-gray-700">
        <p class="p-4 font-bold text-black text-md dark:text-white">My Test</p>
        <ul>

            <li
                class="flex items-center justify-between py-3 text-gray-600 border-b-2 border-gray-100 dark:text-gray-200 dark:border-gray-800">
                <div class="flex items-center justify-start text-sm">
                    <span class="mx-4"> Topic </span>

                </div> <span class="mx-4 text-gray-400 dark:text-gray-300"> Total Marks </span> <span
                class="mx-4 text-gray-400 dark:text-gray-300"> Marks Scored </span> <span
                class="mx-4 text-gray-400 dark:text-gray-300"> Date </span>

            </li>
            <%
            for (SaveResult result : resultList) {
            %>
            <li
                class="flex items-center justify-between py-3 text-gray-600 border-b-2 border-gray-100 dark:text-gray-200 dark:border-gray-800">
                <div class="flex items-center justify-start text-sm">
                    <span class="mx-4"> <%=result.getTopic().getTopicName()%>
                    </span>

                </div> <span class="mx-4 text-gray-400 dark:text-gray-300"> <%=result.getTotalMarks()%>
            </span> <span class="mx-4 text-gray-400 dark:text-gray-300"> <%=result.getObtainedMarks()%>
            </span> <span class="mx-4 text-gray-400 dark:text-gray-300"> <%=result.getFormattedSubmittedAt()%>
            </span>

            </li>
            <%
            }
            %>
            <!-- Repeat the list items here -->
        </ul>
    </div>


   





    <%--  <table border="">

        <tr>
            <th>Topic</th>
            <th>Total Marks</th>
            <th>Marks Obtained</th>
            <th>Date</th>
        </tr>

        <%
        for (SaveResult result : resultList) {
        %>
        <tr>
            <td><%=result.getTopic().getTopicName()%></td>
            <td><%=result.getTotalMarks()%></td>
            <td><%=result.getObtainedMarks()%></td>
            <td><%=result.getFormattedSubmittedAt()%></td>
        </tr>
        <%
        }
        %>


    </table>
 --%>
</body>
</html>