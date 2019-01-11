<jsp:useBean id="patient" scope="request" type="ua.bondarenkojek.homework.jpa.model.Patient"/>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient</title>
    <link rel="stylesheet" href="view/css/style.css">
</head>
<body>


<div class="form-style-8">
    <table>

        <tr>
            <th>Patient ID</th>
            <th>Patient name</th>
        </tr>

        <tr>
            <td>${patient.id}</td>
            <td>${patient.name}</td>
        </tr>
    </table>
</div>

</body>
</html>
