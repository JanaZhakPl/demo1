<!DOCTYPE html>
<html>
<head>
  <title>MyLibraryApp</title>
</head>
<body>
<h1>Main page</h1>
<hr>
<a href="/account">Account page</a>
<br />
<a href="/books">Books page</a>
<br />
<a href="/users">Users page</a>
<hr>
<form action="/books" method="get">
  Search by title: <input type="text" name="title"><br>
  <input type="submit" value="Search">
</form>
<#list books as book>
  <div>
    <p><b>${book.title}</b> ${book.author} | <a href="/books/${book.id}">More information</a></p>
  </div>
<#else>
  <h3>There is no books in the library</h3>
</#list>
<hr />
<form action="/logout" method="post">
  <input type="submit" value="Logout">
</form>
</body>
</html>