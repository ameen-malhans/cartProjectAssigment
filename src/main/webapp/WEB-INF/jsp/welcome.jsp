<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
<script src="js/custom.js"></script>
</head>
<body>


<header>
 
  <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container-fluid">
     <div>
        Please choose listed servers:
    </div>
   </div>
 </nav>
</header>


	<div class="container">


		<form id="selectedServers" method="get" action="selected">
		
			<strong>Select Servers:</strong> 
			<select id="multiple-checkboxes" multiple="multiple">
				<c:forEach items="${servers}" var="server">
					<option value="${server.serverId}">${server.serverName} - ${server.formattedPrice}</option>
				</c:forEach>
			</select>
			
			<button type="submit" onclick="serversToBuy();" class="btn btn-primary">Submit Servers</button>
		</form>


	</div>
</body>
</html>
