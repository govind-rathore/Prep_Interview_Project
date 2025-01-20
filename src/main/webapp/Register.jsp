<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>


<div class="flex justify-center items-center min-h-screen bg-gray-100">
    <div class="flex flex-col max-w-lg w-full px-8 py-8 bg-white rounded-lg shadow dark:bg-gray-800 sm:px-6 md:px-8 lg:px-10">
        <div class="self-center mb-2 text-xl font-light text-gray-800 sm:text-2xl dark:text-white">
            Create a new account
        </div>
        <span class="justify-center text-sm text-center text-gray-500 flex-items-center dark:text-gray-400">
            Already have an account?
            <a href="Login.jsp" target="_blank" class="text-sm text-blue-500 underline hover:text-blue-700">
                Sign in
            </a>
        </span>
        <div class="p-6 mt-8">
            <form action="register-user" method="post">
                <div class="flex flex-col mb-2">
                    <div class="relative">
                        <input type="text" name="username" id="create-account-pseudo" class="rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" name="pseudo" placeholder="UserName" />
                    </div>
                </div>
                <div class="flex flex-col mb-2">
                    <div class="relative">
                        <input type="email" name="email" id="create-account-email" class="rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" placeholder="Email" />
                    </div>
                </div>
                <div class="flex flex-col mb-2">
                    <div class="relative">
                        <input type="password" name="password" id="create-account-email" class="rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" placeholder="Password" />
                    </div>
                </div>
               
<select name="role" id="role" onchange="toggleKeyField()" class="block px-4 py-3 text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm w-full max-w-lg focus:outline-none focus:ring-primary-500 focus:border-primary-500" >
       <option value="USER">User</option>
        <option value="ADMIN">Admin</option>
</select>

<div class="flex flex-col mb-2" >
                    <div class="relative" >
                    <div id="admin-key-field" style="display: none;">
                        <input type="text" name="adminKey" id="create-account-email" class="rounded-lg border-transparent flex-1 appearance-none border border-gray-300 w-full py-2 px-4 bg-white text-gray-700 placeholder-gray-400 shadow-sm text-base focus:outline-none focus:ring-2 focus:ring-purple-600 focus:border-transparent" placeholder="Authorization Key" />
                   </div>
                    </div>
                </div>

                <div class="flex w-full my-4">
                    <button type="submit" class="py-2 px-4 bg-purple-600 hover:bg-purple-700 focus:ring-purple-500 focus:ring-offset-purple-200 text-white w-full transition ease-in duration-200 text-center text-base font-semibold shadow-md focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-lg">
                        Register
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>




<script>
function toggleKeyField() {
    const role = document.getElementById("role").value;
    const keyField = document.getElementById("admin-key-field");
    keyField.style.display = role === "ADMIN" ? "block" : "none";
}
</script>












	<!-- <h1>Register Your Details:</h1>


	<form action="register-user" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="role">Register as:</label>
    <select name="role" id="role" onchange="toggleKeyField()">
        <option value="USER">User</option>
        <option value="ADMIN">Admin</option>
    </select><br><br>

    <div id="admin-key-field" style="display: none;">
        <label for="adminKey">Authorization Key:</label>
        <input type="text" id="adminKey" name="adminKey"><br><br>
    </div>

    <input type="submit" value="Register">
</form>

<script>
function toggleKeyField() {
    const role = document.getElementById("role").value;
    const keyField = document.getElementById("admin-key-field");
    keyField.style.display = role === "ADMIN" ? "block" : "none";
}
</script>

 -->



	
	
