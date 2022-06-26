<!DOCTYPE html>
<html>
    <head>
        <title>MyLibraryApp</title>
    </head>
    <body>
    <h1>MyLibraryApp</h1>
    <hr>
    <h4>BookShelf</h4>
    <form action="/" method="get">
        Search by title: <input type="text" name="title"><br>
        <input type="submit" value="Search">
    </form>
    <#list products as product>
        <div>
            <p><b>${product.title}</b>  ${product.author} | <a href="/product/${product.id}">More information</a></p>
        </div>
        <#else>
        <h3>There is no books in the library</h3>
    </#list>
    <hr>
    <h3>Add new book</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Book Title: <input type="text" name="title"/><br><br>
        Book Author: <input type="text" name="author"/><br><br>
        Book Genre: <input type="text" name="genre"/><br><br>
        Book Description: <input type="text" name="description"/><br><br>
        Image: <input type="file" name="file"/><br><br>
        <input type="submit" value="Add new book"/>
    </form>
    </body>
</html>