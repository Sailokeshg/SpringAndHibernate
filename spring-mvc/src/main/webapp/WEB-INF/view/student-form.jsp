<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
     <title>Student Registration Form</title>
</head
<body>

     <form:form action="processForm" modelAttribute="student">
     First name: <form:input path="firstName"/>

     <br><br>

     Last name: <form:input path="lastName"/>

     <br><br>
     Country:
     &ensp;<form:select path="country">
          <form:options items="${student.countryOptions}"/>

     </form:select>
     <br><br>
Favourite Language:

     Java<form:radiobutton path="favouriteLanguage" value="Java"/>
     Python<form:radiobutton path="favouriteLanguage" value="Python"/>
     C#<form:radiobutton path="favouriteLanguage" value="C#"/>
     Ruby<form:radiobutton path="favouriteLanguage" value="Ruby"/>

     <br><br>
Operating System:

       Linux<form:checkbox path="operatingSystems" value="Linux"/>
       Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
       Windows<form:checkbox path="operatingSystems" value="Windows"/>

      <br><br>
     <input type="submit" value="Submit"/>
     </form:form>


</body>
</html>