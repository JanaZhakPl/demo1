<!DOCTYPE html>
<html>
<head>
    <title>MyLibraryApplication</title>
</head>
<body>
<h1>Registration page</h1>
<hr>
<form action="/registration" method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Phone Number: <input type="text" name="phoneNumber" pattern="\+?[0-9\s\-\(\)]+"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Registration"/>
</form>
</body>
</html>
