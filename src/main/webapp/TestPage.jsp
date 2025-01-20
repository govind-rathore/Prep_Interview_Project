<%@ page import="com.prepinterview.entity.TestQuestion"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
// Fetching the questions list from the request attribute
List<TestQuestion> questions = (List<TestQuestion>) request.getAttribute("qlist");

int userId = Integer.parseInt(request.getParameter("userId"));
int topicId = Integer.parseInt(request.getParameter("topicId"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>

<script>
function calculateResults(event) {
    event.preventDefault(); // Prevent form submission initially

    let totalMarks = 0;
    let obtainedMarks = 0;

    const userId = "<%=userId%>";
    const topicId = "<%=topicId%>";

    const questions = document.querySelectorAll(".question-container");

    // Clear previous results
    document.getElementById("results").innerHTML = "";
    document.getElementById("solutions").innerHTML = "";

    questions.forEach(question => {
        const questionId = question.getAttribute("data-question-id");
        const correctOption = question.getAttribute("data-correct-option");
        const marks = parseInt(question.getAttribute("data-marks"));
        const selectedOption = document.querySelector(
            `input[name="question-${questionId}"]:checked`
        );

        totalMarks += marks;

        if (selectedOption && selectedOption.value === correctOption) {
            obtainedMarks += marks;
        }

        // Display solutions for each question
        const solutionDiv = document.getElementById("solutions");
        const questionHTML = `
            <div style="margin-bottom: 20px;">
                <h3>Question: ${question.querySelector(".question-text").innerText}</h3>
                <div>
                    <strong>A:</strong> ${question.querySelector(".option-a").innerText}
                    ${correctOption === "A" ? "<span style='color: green;'> (Correct)</span>" : ""}
                </div>
                <div>
                    <strong>B:</strong> ${question.querySelector(".option-b").innerText}
                    ${correctOption === "B" ? "<span style='color: green;'> (Correct)</span>" : ""}
                </div>
                <div>
                    <strong>C:</strong> ${question.querySelector(".option-c").innerText}
                    ${correctOption === "C" ? "<span style='color: green;'> (Correct)</span>" : ""}
                </div>
                <div>
                    <strong>D:</strong> ${question.querySelector(".option-d").innerText}
                    ${correctOption === "D" ? "<span style='color: green;'> (Correct)</span>" : ""}
                </div>
                <p>
                    Your Answer: ${
                        selectedOption ? selectedOption.value : "<span style='color: red;'>No Answer</span>"
                    } ${
                        selectedOption && selectedOption.value === correctOption
                            ? "<span style='color: green;'>Correct!</span>"
                            : "<span style='color: red;'>Wrong!</span>"
                    }
                </p>
                <p><strong>Solution:</strong> ${question.getAttribute("data-solution")}</p>
            </div>
        `;
        solutionDiv.innerHTML += questionHTML;
    });

    // Display total and obtained marks
    document.getElementById("results").innerHTML = `
        <h2>Results</h2>
        <p>Total Marks: ${totalMarks}</p>
        <p>Marks Obtained: ${obtainedMarks}</p>
    `;

    // Add hidden input fields for form submission
    const form = document.getElementById("testForm");

    let userIdInput = document.createElement("input");
    userIdInput.type = "hidden";
    userIdInput.name = "userId";
    userIdInput.value = userId;
    form.appendChild(userIdInput);
    
    let topicIdInput = document.createElement("input");
    topicIdInput.type = "hidden";
    topicIdInput.name = "topicId";
    topicIdInput.value = topicId;
    form.appendChild(topicIdInput); 

    let totalMarksInput = document.createElement("input");
    totalMarksInput.type = "hidden";
    totalMarksInput.name = "totalMarks";
    totalMarksInput.value = totalMarks;
    form.appendChild(totalMarksInput);

    let obtainedMarksInput = document.createElement("input");
    obtainedMarksInput.type = "hidden";
    obtainedMarksInput.name = "obtainedMarks";
    obtainedMarksInput.value = obtainedMarks;
    form.appendChild(obtainedMarksInput);

    // Hide the initial question part (user selection)
    document.querySelector(".question-section").style.display = "none";

    // Show the "Submit Results" button after analysis
    document.getElementById("submitButton").style.display = "inline-block";
}

function submitForm(event) {
    // Submit the form when the user is ready after reviewing results
    document.getElementById("testForm").submit();  // Submit form data
}

</script>

</head>
<body>



    <!-- Results Section -->
    <div id="results"></div>

    <!-- Questions Section -->
    <div class="question-section">
        <form id="testForm" action="save-result" method="post">
            <%
            if (questions != null && !questions.isEmpty()) {
            	for (TestQuestion question : questions) {
            %>
            <!-- Question Container -->
            <div class="question-container" data-question-id="<%=question.getQuestionId()%>"
                data-correct-option="<%=question.getCorrectOption()%>" data-marks="<%=question.getMarks()%>"
                data-solution="<%=question.getSolution()%>">
                <h3 class="question-text">
                    Question:
                    <%=question.getQuestion()%></h3>
                <div>
                    <input type="radio" name="question-<%=question.getQuestionId()%>" value="A"> <span
                        class="option-a"><%=question.getOptionA()%></span>
                </div>
                <div>
                    <input type="radio" name="question-<%=question.getQuestionId()%>" value="B"> <span
                        class="option-b"><%=question.getOptionB()%></span>
                </div>
                <div>
                    <input type="radio" name="question-<%=question.getQuestionId()%>" value="C"> <span
                        class="option-c"><%=question.getOptionC()%></span>
                </div>
                <div>
                    <input type="radio" name="question-<%=question.getQuestionId()%>" value="D"> <span
                        class="option-d"><%=question.getOptionD()%></span>
                </div>
            </div>
            <%
            }
            }
            %>

            <button type="button" onclick="calculateResults(event)">Submit Test</button>
        </form>
    </div>

    <!-- Solutions Section -->
    <div id="solutions"></div>

    <!-- Results Section -->
    <div id="results"></div>

    <!-- Submit Button (Initially Hidden) -->
    <button id="submitButton" type="button" style="display: none;" onclick="submitForm(event)">Submit Results</button>


</body>
</html>
