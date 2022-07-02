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
<form action="/home" method="get">
    Search by title: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>
</body>
</html>