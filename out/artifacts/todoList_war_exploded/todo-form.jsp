<%--
  Created by IntelliJ IDEA.
  User: impdmacbook
  Date: 2/26/22
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>

    </h2>
</center>
<div align="center">
    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${Task != null}">
                    <input type="hidden" name="id" value="<c:out value='${Task.id}' />" />
                </c:if>
                <tr>
                    <th>User Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${Task.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${Task.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Country: </th>
                    <td>
                        <input type="text" name="country" size="15"
                               value="<c:out value='${Task.country}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
