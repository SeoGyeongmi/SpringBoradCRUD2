<%--
  Created by IntelliJ IDEA.
  User: seogyeongmi
  Date: 11/30/23
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function updateEditdate() {

        var now = new Date();
        var formattedDate = now.toISOString();

        // hidden input 필드를 통해 서버로 Editdate 전송
        document.getElementById("editdate").value = formattedDate;

        // 필요한 경우 다른 작업 수행
        return true; // 폼 제출을 계속 진행
    }
</script>
<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" onsubmit="updateEditdate()">
    <input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
    <table>
        <tr><td>Category:</td><td>
            <input list="category" name="category" value="<%= u.getCategory()%>">
            <datalist id="category">
                <option value="메모">
                <option value="자기계발">
                <option value="독서">
                <option value="할 일">
            </datalist></td></tr>
        <tr><td>Title:</td><td><input type="text" name="title" value="<%= u.getTitle()%>"/></td></tr>
        <tr><td>Writer:</td><td><input type="text" name="writer" value="<%= u.getWriter()%>" /></td></tr>
        <tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"><%= u.getContent()%></textarea></td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit Post"/>
            <input type="button" value="Cancel" onclick="history.back()"/></td></tr>
    </table>
</form>
</body>
</html>
