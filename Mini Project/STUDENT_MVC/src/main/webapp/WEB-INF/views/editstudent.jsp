<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<form action="/STUDENT_MVC/student/updatestudent" method="post">
  <div class="container">
    <h1>Register Student</h1>
  
    <hr>

    <label for="sid"><b>Student Id</b></label>
    <input type="text" value="${s.sid}" name="sid" id="email" readonly>

    <label for="sname"><b>Student Name</b></label>
    <input type="text" value="${s.sname}" name="sname" id="psw" required>

    <label for="course"><b>Course Name</b></label>
    <input type="text" value="${s.course}" name="course" id="psw-repeat" required>
   <label for="marks"><b>Marks</b></label>
    <input type="text" value="${s.marks}" name="marks" id="psw-repeat" required>
   <label for="year"><b>Enter Year</b></label>
    <input type="text" value="${s.year}" name="year" id="psw-repeat" required>
   
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>
