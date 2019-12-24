<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
</head>
<body>
    <div align="center">
        <h2>Customer List</h2>
        <br><br>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
            <tr>
                <td>
                    <c:out value="${customer.firstName}" />
                </td>
                <td>
                    <c:out value="${customer.lastName}" />
                </td>
                <td>
                    <c:out value="${customer.email}" />
                </td>
                <td>
                    <c:set var="editCustomerUrl">
                        <c:url value="customerDetails">
                            <c:param name="id" value="${customer.id}"/>
                        </c:url>
                    </c:set>
                    <a href="${editCustomerUrl}">Edit</a>
                </td>
                <td>
                    <c:set var="deleteUrl">
                        <c:url value="deleteCustomer">
                            <c:param name="id" value="${customer.id}"/>
                        </c:url>
                    </c:set>
                    <a href="${deleteUrl}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>

        <br><br>
                <a href="home">Home</a>
                <br><br>
                <a href="customerDetails">Add Customer</a>
    </div>
</body>
</html>