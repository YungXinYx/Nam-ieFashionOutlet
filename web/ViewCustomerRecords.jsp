<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Customer> customerList = (List)session.getAttribute("customerList"); %>
        <h1>Customer List</h1>
        <table border="1">
            <tr>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Customer IC</th>
            </tr>
            <% for (Customer customer: customerList){ %>
                <tr>
                    <td><%= customer.getCustomerid() %></td>
                    <td><%= customer.getCustomername() %> </td>
                    <td><%= customer.getCustomeric() %></td>
                </tr>
            <% } %>
            <form action="SortCustomerRecords">
                <input type="submit" name="buttonSort" value="Reset">
                <input type="submit" name="buttonSort" value="Sort by ID">
                <input type="submit" name="buttonSort" value="Sort by Name">
                <input type="submit" name="buttonSort" value="Sort by IC">
            </form>
        </table>
        <br><br>
        <p><a href="../index.html">Back to home page</a></p>
    </body>
</html>


