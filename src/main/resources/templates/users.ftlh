<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApp</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>
<hr>
<h4>BookShelf</h4>
<form action="/users" method="get">
    Search by email: <input type="text" name="email"><br>
    <input type="submit" value="Search">
</form>
<#list users as user>
    <div>${user.name}</div>
    <div>${user.email}</div>
    <div>${user.numberPhone}</div><br><br>
    <#else>
    <h3>There are no users</h3>
</#list>
</body>
</html>