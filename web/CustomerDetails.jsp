<%-- 
    Document   : CustomerDetails
    Created on : Mar 27, 2022, 2:53:49 PM
    Author     : melvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <p>Please fill up your personal details.</p>
        <div class="registerformcontainer">
            <form action="AddCustomerDetails" class="registerform">
                <div>
                    <label for="customername"><b>Name</b></label><br/>
                    <input type="text" placeholder="Enter your name" name="customername" id="customeric" required size="25">
                </div>

                <div>
                    <label for="customeric"><b>IC</b></label><br/>
                    <input type="text" placeholder="Enter your NRIC" name="customeric" id="customeric" required size="25">
                </div>

                <div>
                    <label for="gender"><b>Gender</b></label><br/>
                    <input type="radio" name="gender" id="gender" value="M" required><label>Male</label>
                    <input type="radio" name="gender" id="gender" value="F" required><label>Female</label>
                </div>

                <div>
                    <label for="address1"><b>Address Line 1</b></label><br/>
                    <input type="text" placeholder="Enter Address Line 1" name="address1" id="address1" required size="25">
                </div>

                <div>
                    <label for="address2"><b>Address Line 2</b></label><br/>
                    <input type="text" placeholder="Enter Address Line 2" name="address2" id="address2" required size="25">
                </div>

                <div>
                    <label for="postcode"><b>Postcode</b></label><br/>
                    <input type="text" placeholder="Enter your postcode" name="postcode" id="postcode" required size="25">
                </div>

                <div>
                    <label for="country"><b>Country</b></label><br/>
                    <input type="text" placeholder="Enter your Country" name="country" id="country" required size="25">
                </div>

                <div>
                    <input type="submit" value="Next">
                </div>
            </form>
        </div>
    </body>
</html>
