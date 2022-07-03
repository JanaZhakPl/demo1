<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApp</title>
</head>
<body>
<h1>Users page</h1>
<hr>
<h4>BookShelf</h4>
<form action="/users" method="get">
    Search by email: <input type="text" name="email"><br>
    <input type="submit" value="Search">
</form>
<#list users as user>
    <div>${user.name}</div>
    <div>${user.email}</div>
    <div>${user.phoneNumber}</div><br><br>
    <#else>
    <h3>There are no users</h3>
</#list>
</body>
</html>