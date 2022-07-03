<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApp</title>
</head>
<body>
<h1>MyLibraryApp|<a href="/login">Login</a></h1><hr>
<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>
<hr>
<h4>BookShelf</h4>
<form action="/books" method="get">
    Search by title: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>
<#list books as book>
    <div>
        <p><b>${book.title}</b>  ${book.author} | <a href="/book/${book.id}">More information</a></p>
    </div>
<#else>
    <h3>There is no books in the library</h3>
</#list>
</body>
</html>