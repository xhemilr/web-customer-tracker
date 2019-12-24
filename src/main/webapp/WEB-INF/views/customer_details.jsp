<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
</head>
<body>
    <div align="center">
        <h2>Add Customer</h2>
        <br><br>
        <form:form action="processCustomer" modelAttribute="customer">
            First name:<form:input path="firstName"/>
            <br><br>
            Last name:<form:input path="lastName"/>
            <br><br>
            Email:<form:input path="email"/>
            <br><br>
            <input type="submit" value="Register"/>
        </form:form>
        <h2><a href="customerList">Customer List</a>
    </div>
</body>
</html>