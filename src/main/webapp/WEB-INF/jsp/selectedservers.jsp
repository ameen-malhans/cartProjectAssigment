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
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container-fluid">
     <div>
         <a href="/getAllServers" class="previous">&laquo; Previous</a>
    </div>
   </div>
 </nav>
</header>


<div id="totalAmount" display:none class="alert alert-info" role="alert">
   <span>Total Amount Charged  </span> :: <span id="total"> </span>   
</div>
<div class="container">
		<form id="selectedServers" method="get" onsubmit="return submitOrder();">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Server Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${selectedServers}" var="server">
					<tr id="server_${server.serverId}">
						<td id="serverName_${server.serverId}">${server.serverName}</td>
						<td id="serverPrice_${server.serverId}">${server.serverPrice}</td>
						<td>
							<div class="number">
								<input type="number" id="quantity_${server.serverId}" value="1" min="1" max="2">
							</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<button type="submit"  class="btn btn-primary">Submit Order</button>
		
		</form>

	</div>
	
	</body>
</html>
