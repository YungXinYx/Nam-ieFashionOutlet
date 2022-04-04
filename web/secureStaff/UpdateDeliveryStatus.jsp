<%-- 
    Document   : UpdateDeliveryStatus
    Created on : Mar 30, 2022, 7:04:52 PM
    Author     : kuxinyau
--%>

<%@page import="java.util.*, model.Delivery" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nam'ie | Delivery</title>
        <script src="../jsFile/sortTable.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <style>
            i {
                float: right;
                padding-right: 4px;
                padding-top: 3px;
            }
        </style>
    </head>
    <body>
        <!-- retrieve session object, deliveryList -->
        <%
            List<Delivery> deliveryList = (List) session.getAttribute("deliveryList");
            String success = (String)session.getAttribute("success");
        %>
        <form action="../UpdateDeliveryStatus" method="post">
            <input type="submit" value="Save" />
            <% if (success.equals("success")) { %>
            <div>
                <p>Updated Successfully</p>
            </div>
            <%} else if (success.equals("fail")) { %>
            <div>
                <p>Error: Unable to Update Delivery Status</p>
            </div>
            <%}%>

            <!-- Display Delivery -->
            <table border="1" id="deliveryTable" width="100%">
                <tr>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(1)')" style="cursor:pointer">Delivery ID <i class="fas fa-sort"></i></th>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(2)')" style="cursor:pointer">Delivery Date <i class="fas fa-sort"></i></th>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(3)')" style="cursor:pointer">Receiver Name <i class="fas fa-sort"></i></th>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(4)')" style="cursor:pointer">Receiver Phone Number <i class="fas fa-sort"></i></th>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(5)')" style="cursor:pointer">Address <i class="fas fa-sort"></i></th>
                    <th onclick="sortTable('#deliveryTable', '.delivery', 'td:nth-child(6)')" style="cursor:pointer">Delivery Status <i class="fas fa-sort"></i></th>
                </tr>
                <% for (Delivery delivery : deliveryList) {%>
                <tr class="delivery">
                    <td><%= delivery.getDeliveryid()%></td>
                    <td><%= delivery.getDeliverydatetime()%> </td>
                    <td><%= delivery.getReceivername()%></td>
                    <td><%= delivery.getReceiverphonenumber()%></td>
                    <td><%= delivery.getAddressline1()%>, <%= delivery.getAddressline2()%> <%= delivery.getPostcode()%> <%= delivery.getCountry()%></td>
                    <!-- preparing, packaging, shipping, delivered, missing, canceled -->
                    <% String[] statusArr = new String[]{"Preparing", "Packaging", "Shipping", "Delivered", "Missing", "Canceled"};%>
                    <td>
                        <select name="<%= delivery.getDeliveryid()%>" id="status">
                            <% for (int i = 0; i < statusArr.length; i++) {%>
                            <option value="<%= statusArr[i]%>"
                                    <% if (delivery.getDeliverystatus().equals(statusArr[i])) { %>
                                    selected="selected"
                                    <%}%>
                                    ><%= statusArr[i]%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <% }%>
            </table>
        </form>
    </body>
</html>
