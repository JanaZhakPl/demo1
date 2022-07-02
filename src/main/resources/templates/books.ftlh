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
<h3>Add new book</h3>
<form action="/book/create" method="post" enctype="multipart/form-data">
    Book Title: <input type="text" name="title"/><br><br>
    Book Author: <input type="text" name="author"/><br><br>
    Book Genre: <input type="text" name="genre"/><br><br>
    Book Description: <input type="text" name="description"/><br><br>
    Image: <input type="file" name="image"/><br><br>
    <input type="submit" value="Add new book"/>
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
<#--    <#if user.email??></#if>-->
<hr>

</body>
</html>