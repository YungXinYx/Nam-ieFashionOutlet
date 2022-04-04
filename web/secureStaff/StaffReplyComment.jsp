<%-- 
    Document   : StaffReplyComment
    Created on : Mar 31, 2022, 7:02:42 PM
    Author     : kuxinyau
--%>

<%@page import="java.util.*, model.Feedback" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Nam'ie | Comment</title>
        <style>
            textarea {
                resize: none;
                width: 80%;
                height: 35px;
                border-radius: 5px;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <!-- retrieve session object, feedbackList -->
        <%
            List<Feedback> feedbackList = (List) session.getAttribute("feedbackList");
            String success = (String)session.getAttribute("success");
        %>
        <form action="../UpdateStaffReply" method="post">
            <% if (success.equals("success")) { %>
            <div>
                <p>Replied Successfully</p>
            </div>
            <%} else if (success.equals("fail")) { %>
            <div>
                <p>Error: Unable to Reply the Comment. Comment cannot be Empty</p>
            </div>
            <%}%>
            
            <!-- Display items -->
            <% for (Feedback feedback : feedbackList) {%>

            Product ID: <%= feedback.getProductid().getProductid() %><br/>
            Product Name: <%= feedback.getProductid().getProductname() %><br/>
            Feedback Code: <%= feedback.getFeedbackcode() %><br/>
            Rating: <%= feedback.getRating() %><br/>
            Comments: <%= feedback.getComments() %><br/>
            Staff Reply: 
            <% if (feedback.getStaffreply() == null) { %>
            <!--<div id="txtboxStaffReply">Staff Reply</div>
            <div id="reply" class="staffReplyBox" role="textbox" contenteditable="true" aria-multiline="true" aria-labelledby="txtboxStaffReply" aria-placeholder="Reply..." spellcheck="true"></div>-->
            <textarea maxlength="100" name="<%= feedback.getFeedbackcode() %>"></textarea>
            <button type="submit" value="btn<%= feedback.getFeedbackcode() %>" name="btn<%= feedback.getFeedbackcode() %>"><i class="fa fa-send"></i></button>
            <%} else {%>
            <%= feedback.getStaffreply()%><br/>
            <%}%><hr/>
            <%}%>
        </form>
    </body>
    <!--<script>
        function getText() {
            let text = document.querySelector('[role=textbox]').innerText;
        }
    </script>-->
</html>
