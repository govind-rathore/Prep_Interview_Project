<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>




   

    <div class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="flex flex-col w-full max-w-md px-4 py-8 bg-white rounded-lg shadow dark:bg-gray-800 sm:px-6 md:px-8 lg:px-10">
        <div class="self-center mb-6 text-xl font-light text-gray-600 sm:text-2xl dark:text-white">
            Login To Your Account
        </div>
        <div class="mt-8">
            <form action="login" method="post"autoComplete="off">
                <div class="flex flex-col mb-2">
                    <div class="flex relative">
                        <span class="rounded-l-md inline-flex items-center px-3 border-t bg-white border-l border-b border-gray-300 text-gray-500 shadow-sm text-sm">
                            <!-- SVG Icon -->
                        </span>
                        <input type="email" name="email" id="sign-in-email" class="rounded-r-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" placeholder="Your email" />
                    </div>
                </div>
                <div class="flex flex-col mb-6">
                    <div class="flex relative">
                        <span class="rounded-l-md inline-flex items-center px-3 border-t bg-white border-l border-b border-gray-300 text-gray-500 shadow-sm text-sm">
                            <!-- SVG Icon -->
                        </span>
                        <input type="password" name="password" id="sign-in-password" class="rounded-r-lg flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" placeholder="Your password" />
                    </div>
                </div>
                
                
        <!-- Hidden field for topicId -->
        <input type="hidden" name="topicId" value="<%=request.getParameter("topicId") != null ? request.getParameter("topicId") : ""%>"> 
        <input type="hidden" name="topicName" value="<%=request.getParameter("topicName")%>">
                
                <div class="flex items-center mb-6 -mt-4">
                    <div class="flex ml-auto">
                        <a href="#" class="inline-flex text-xs font-thin text-gray-500 sm:text-sm dark:text-gray-100 hover:text-gray-700 dark:hover:text-white">
                            Forgot Your Password?
                        </a>
                    </div>
                </div>
                <div class="flex w-full">
                    <button type="submit" class="py-2 px-4 bg-purple-600 hover:bg-purple-700 focus:ring-purple-500 focus:ring-offset-purple-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-lg">
                        Login
                    </button>
                </div>
            </form>
        </div>
        <div class="flex items-center justify-center mt-6">
            <a href="Register.jsp" target="_blank" class="inline-flex items-center text-xs font-thin text-center text-gray-500 hover:text-gray-700 dark:text-gray-100 dark:hover:text-white">
                <span class="ml-2">You don't have an account?</span>
            </a>
        </div>
    </div>
</div>
    









    <%-- <h1>Login Here</h1>

    <form action="login" method="post">
        

        <label for="email">Email:</label> <input type="email" id="email" name="email" required><br> <br>
        <label for="password">Password:</label> <input type="password" id="password" name="password" required><br>
        <br> <input type="submit" value="LogIn"> <br>

        <!-- Hidden field for topicId -->
        <input type="hidden" name="topicId" value="<%=request.getParameter("topicId") != null ? request.getParameter("topicId") : ""%>"> 
        <input type="hidden" name="topicName" value="<%=request.getParameter("topicName")%>">

    </form> --%>



</body>
</html>

