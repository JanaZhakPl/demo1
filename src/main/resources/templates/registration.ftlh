<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApplication</title>
</head>
<body>
<h1>MyLibraryApplication</h1>
<hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    UserName: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Phone Number: <input type="text" name="numberPhone"pattern="\+?[0-9\s\-\(\)]+"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Registration"/>
</form>

</body>
</html>




