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
            <span class="block">
               Test 
            </span>
           
        </h2>
        
    </div>
</div>

    
    
    
    

<div class="bg-white dark:bg-gray-800 ">
    <div class="text-center w-full mx-auto py-12 px-4 sm:px-6 lg:py-16 lg:px-8 z-20">
        <h2 class="text-xl font-extrabold text-black dark:text-white sm:text-3xl">
            <span class="block">
             <%=request.getParameter("topicName")%>
            </span></h2>
            <span class="block text-indigo-500">
                  <p>Questions: 20       Time: 30 minutes </p>
            </span>
       
        
        <div class="lg:mt-0 lg:flex-shrink-0">
            <div class="mt-12 inline-flex rounded-md shadow">
                <button  onclick="window.location.href='topic-wise-test?topicId=<%=request.getParameter("topicId")%>&userId=<%=request.getParameter("userId")%>'" class="py-4 px-6  bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500 focus:ring-offset-indigo-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2  rounded-lg ">
                    Get started
                </button>
            </div>
        </div>
    </div>
</div>







   <%--  <h3>
        Test Topic:
        <%=request.getParameter("topicName")%>
    </h3>


    <p>Questions: 20 Time: 30 minutes Marks: 20 Marks</p>



    <button
        onclick="window.location.href='topic-wise-test?topicId=<%=request.getParameter("topicId")%>&userId=<%=request.getParameter("userId")%>'">Start
        Test</button>
 --%>






</body>
</html>