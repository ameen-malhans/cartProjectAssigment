# SHOPPING CART APPLICATION

## About

This is a project which produces a REST API (Spring-Boot/HTML,CSS,JavaScript/Bootstrap) that allows users to shop for the servers and cover the following scenarios:

1) Anyone can order the servers available on the main page</br>
2) Servers are available for selection with price </br>
3) Client selects the desired server and submit the request to get view for adding quantity and calculate total.</br>
4) Client can add Minimum 1 server in the order. </br>
5) Client can add Maximum 2 servers in the order.</br>
6) The Total Amount is shown to the client after choosing right quanity at the above of the page. </br>



## How to run

1) Import the project in IDE (Eclipse/Intellij)</br>
2) Launch Java Application using "SpringBootWebApplication" class </br>
3) Go to the web browser and visit : http://localhost:8080 </br>
   
## Explaination

### 1) Anyone can order the servers: 

   Host: GET http://localhost:8080/getAllServers </br>

   Description : This MVC webservice provides servers on the main Page. </br>
   
   (https://raw.githubusercontent.com/ameen-malhans/cartassignment/main/src/main/resources/static/images/getAllServers.png)
             
	
### 2) Client selects the desired server and submit the request get the view for adding quantity  : 

   Host: GET http://localhost:8080/selected?{serverIDs} </br>
         Example : http://localhost:8080/selected?submittedIds=1%2C2     </br>

   Description : This MVC webservice provides selected servers in the view.</br>
   
    (https://raw.githubusercontent.com/ameen-malhans/cartassignment/main/src/main/resources/static/images/selectedServers.png)
   
### 3) Client submit the request for Total Amount:

Client will get the the Total Amount right above the page.</br>

    (https://raw.githubusercontent.com/ameen-malhans/cartassignment/main/src/main/resources/static/images/totalAmount.png)

### 3) Test case:

Performed unit test using junit Mockito.(Happy Path)</br>

## Improvements

1) We can enhance unit and add integration testing </br>
2) We can add more validation through backend using MVC spring boot </br>
3) We can add exception handling by using spring boot inteceptors on controllers </br>
4) JSP can be refactored to create separate for header/footer etc.