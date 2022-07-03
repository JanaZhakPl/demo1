<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApp</title>
</head>
<body>
<h1>MyLibraryApp</h1>
<hr>
<h4>BookInfo</h4>
<#list images as img>
    <img src="/images/${img.id}}" height="460px"/><br><br>
</#list>

<b>Title: </b>${book.title}<br>
<b>Author: </b>${book.author}<br>
<b>Genre: </b>${book.genre}<br>
<b>Description: </b>${book.description}<br>

<hr>

<form action="/books/delete/${book.id}" method="post">
    <input type="submit" value="Delete book"/>
</form>
</body>
</html>