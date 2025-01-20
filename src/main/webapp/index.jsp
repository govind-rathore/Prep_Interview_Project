<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>






<main class="relative h-screen overflow-hidden bg-white dark:bg-gray-800">
    <header class="z-30 flex items-center w-full h-24 sm:h-32">
        <div class="container flex items-center justify-between px-6 mx-auto">
            <div class="text-3xl font-black text-gray-800 uppercase dark:text-white">
                Prep_Master
            </div>
            <div class="flex items-center">
                <nav class="items-center hidden text-lg text-gray-800 uppercase font-sen dark:text-white lg:flex">
                    <a href="#" class="flex px-6 py-2">
                        Home
                    </a>
                   
                    <a href="#" class="flex px-6 py-2">
                        Contact
                    </a>
                    <a href="Login.jsp" class="flex px-6 py-2">
                        Login
                    </a>
                </nav>
                <button class="flex flex-col ml-4 lg:hidden">
                    <span class="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                    <span class="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                    <span class="w-6 h-1 mb-1 bg-gray-800 dark:bg-white">
                    </span>
                </button>
            </div>
        </div>
    </header>
    <div class="relative z-20 flex items-center overflow-hidden bg-white dark:bg-gray-800">
        <div class="container relative flex px-6 py-16 mx-auto">
            <div class="relative z-20 flex flex-col sm:w-2/3 lg:w-2/5">
                <span class="w-20 h-2 mb-12 bg-gray-800 dark:bg-white">
                </span>
                <h1 class="flex flex-col text-2xl font-black leading-none text-gray-800 uppercase font-bebas-neue sm:text-8xl dark:text-white">
                  Empowering 
                    <span class="text-xl sm:text-3xl">
                        You to Ace Every Interview with Confidence!
                    </span>
                </h1>
                <p class="text-sm text-gray-700 sm:text-base dark:text-white">
                   Your Gateway to Cracking Interviews: Real Stories, Expert Insights, and Ultimate Prep!
                </p>
                <div class="flex mt-8">
                    <a href="all-topics" class="px-4 py-2 mr-4 text-white uppercase bg-pink-500 border-2 border-transparent rounded-lg text-md hover:bg-pink-400">
                        Get started
                    </a>
                 
                </div>
            </div>
            
        </div>
    </div>
</main>



<!-- 
    <h1>Welcome to PrepInterview</h1>

    <a href="Register.jsp">Register</a>
    <a href="Login.jsp">LogIn</a>
    <a href="all-topics">Prepare Now</a> -->

</body>
</html>