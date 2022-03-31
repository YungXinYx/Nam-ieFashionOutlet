<!DOCTYPE html>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>

<%
    List<Category> categoryList = (List) session.getAttribute("categoryList");
%>
<html>

    <head>
        <title>Nam'ie | Add Product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body>
        <h1>Add Product</h1>
        <form class="addProductForm" method="POST" enctype="multipart/form-data" action="AddProduct">
            <label>Product Name</label>
            <input type="text" name="productname" id="productname" required><br/>
            <label>Product Price</label>
            <input type="text" name="productprice" id="productprice" required><br/>

            <label>Category</label>
            <select id="category" name="category">
                <% for (int i = 0; i < categoryList.size(); i++) {%>
                <option value="<%= categoryList.get(i).getCategoryname()%>"><%= categoryList.get(i).getCategoryname()%></option>
                <%}%>
            </select>
            <br/>
            
            <label>Product Size and Quantity</label><br/>
            <label>S:</label><input type="number" min="0" name="size-s" id="size-s" size="5" required><br/>
            <label>M:</label><input type="number" min="0" name="size-m" id="size-m" size="5" required><br/>
            <label>L:</label><input type="number" min="0" name="size-l" id="size-l" size="5" required><br/>
            <label>XL:</label><input type="number" min="0" name="size-xl" id="size-xl" size="5" required><br/><br/>

            <label>Product Image</label><br/>
            <input type="file" name="productimage1" id="productimage1" required><br/>
            <input type="file" name="productimage2" id="productimage2"><br/>
            <input type="file" name="productimage3" id="productimage3"><br/>
            <input type="submit" value="Submit">

        </form>
    </body>

</html>