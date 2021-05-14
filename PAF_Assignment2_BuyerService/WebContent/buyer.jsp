<%@page import="model.Buyer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="components/jquery-3.2.1.min.js"></script>
<script src="components/main.js"></script>

<link rel="stylesheet" href="https:code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
     <div class="container"> 
		<div class="row">  
		
			<div class="col-8">       
				<h1 class="m-3">Buyer Management</h1>        
				
				<form id="formBuyer" name="formBuyer" method="post" action="buyer.jsp">  
					Buyer Code:  
					<input id="BuyerCode" name="BuyerCode" type="text" class="form-control form-control-sm">  
					
					<br> 
					Buyer Name:  
					<input id="BuyerName" name="BuyerName" type="text" class="form-control form-control-sm">  
					
					<br>
					 Buyer Email:  
					 <input id="BuyerEmail" name="BuyerEmail" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Buyer Contact Number:  
					 <input id="BuyerContactNumber" name="BuyerContactNumber" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					  Buyer Address:  
					 <input id="BuyerAddress" name="BuyerAddress" type="text" class="form-control form-control-sm">  
					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 <input type="hidden" id="hidBuyerIDSave" name="hidBuyerIDSave" value=""> 
	 
					</form> 
				
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br> 
				
				
				<br> 
				<div id="divBuyerGrid">   
					<%
   					Buyer buyerObj = new Buyer();
   				    out.print(buyerObj.readBuyer());
   					%>  
					
					
				</div> 
				  
 			</div>
 		 
 		</div>    
 		
 
	</div> 
     
</body>
</html>