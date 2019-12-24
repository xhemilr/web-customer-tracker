<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
</head>
<body>
    <div align="center">
        <h2>${message}</h2>
        <br><br>
        First name: ${customer.firstName}
        <br><br>
        Last name: ${customer.lastName}
        <br><br>
        email: ${customer.email}
        <br><br>
        <h2><a href="home">Home</a>
        <br><br>
        <h2><a href="customerList">Customer List</a>

    </div>


</body>
</html>