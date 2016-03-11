<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 

</head>
<body>
<h1>Welcome to this web!</h1>

<form action="springmvc/testJsonParams" method="post">
	
		JSON:<input type="text" name="jsonStr"/>
		<input type="submit" value="submit"/>
		
	</form>
	<form action="./find/jsonbyid" method="get">
	<p>id:<input type="text" name="id">
	<input type="submit" value="Submit"/>
		
	</form>

		
	</form>
</body>

</html>