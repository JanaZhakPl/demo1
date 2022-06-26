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
    <img src="/images/${img.id}" height="460px"/><br><br>
</#list>-->

<b>Title: </b>${product.title}<br>
<b>Author: </b>${product.author}<br>
<b>Genre: </b>${product.genre}<br>
<b>Description: </b>${product.description}<br>

<hr>

<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete book"/>
</form>
</body>
</html>