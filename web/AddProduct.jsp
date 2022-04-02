<!DOCTYPE html>
<%@page import="model.Category" %>
<%@page import="java.util.List" %>

<%
    List<Category> categoryList = (List) session.getAttribute("categoryList");
%>
<html>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nam'ie | Add Product</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
        <link href="cssFile/AddProduct.css" type="text/css" rel="stylesheet" />
    </head>

    <body>
        <div class="center">
            <h1>Add Product</h1>
            <form class="addProductForm" method="POST" enctype="multipart/form-data" action="AddProduct">
                <div class="addProductContainer">
                    <input type="text" name="productname" id="productname" required>
                    <label>Product Name</label>
                </div>
                <div class="addProductContainer">
                    <input type="text" name="productprice" id="productprice" required>
                    <label>Product Price</label>
                </div>
                <div class="addProductLabel">
                    <label>Category</label>
                </div>
                <div class="categorySelection">
                    <select id="category" name="category">
                        <% for (int i = 0; i < categoryList.size(); i++) {%>
                        <option value="<%= categoryList.get(i).getCategoryname()%>"><%= categoryList.get(i).getCategoryname()%></option>
                        <%}%>
                    </select>
                </div>
                <br/>
                <div class="addProductLabel">
                    <label>Product Size and Quantity</label>
                </div>
                <table>
                    <tr>
                        <td>
                            <div class="addProductContainer">
                                <input type="number" min="0" name="size-s" id="size-s" size="5" required>
                                <label>S</label>
                            </div>
                        </td>
                        <td>
                            <div class="addProductContainer">
                                <input type="number" min="0" name="size-m" id="size-m" size="5" required>
                                <label>M</label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="addProductContainer">
                                <input type="number" min="0" name="size-l" id="size-l" size="5" required>
                                <label>L</label>
                            </div>
                        </td>
                        <td>
                            <div class="addProductContainer">
                                <input type="number" min="0" name="size-xl" id="size-xl" size="5" required>
                                <label>XL</label>
                            </div>
                        </td>
                    </tr>
                </table>

                <div class="addProductLabel">
                    <label>Product Image</label>
                </div>
                <input type="file" name="productimage1" id="productimage1" required>
                <input type="file" name="productimage2" id="productimage2">
                <input type="file" name="productimage3" id="productimage3">

                <input type="submit" value="Submit"><br/><br/>

            </form>
        </div>

    </body>

</html>