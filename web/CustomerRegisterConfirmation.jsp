<h3>
    <%
        boolean success = (Boolean) session.getAttribute("success");
        if (success) {
            out.println("Your account is created successfully.");
        } else {
            out.println("Error: Unable to add new item.");
        }
    %>
</h3>
<p><a href="CustomerRegisterDetails.html">Back to register</a></p>