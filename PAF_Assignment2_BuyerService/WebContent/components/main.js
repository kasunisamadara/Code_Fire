/**
 * 
 */
$(document).ready(function() 
{  
	if ($("#alertSuccess").text().trim() == "")  
	{   
		$("#alertSuccess").hide();  
	} 
	$("#alertError").hide(); 
}); 

//SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 

	// Form validation-------------------  
	var status = validateBuyerForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 

	// If valid------------------------  
	var t = ($("#hidBuyerIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "BuyerAPI",
		type : type,
		data : $("#formBuyer").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onBuyerSaveComplete(response.responseText, status);
		}
	});
}); 

function onBuyerSaveComplete(response, status){
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Saved.");
			$("#alertSuccess").show();
					
			$("#divBuyerGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Saving.");
		$("#slertError").show();
	}else{
		$("#alertError").text("Unknown Error while Saving.");
		$("#alertError").show();
	}
	$("#hidBuyerIDSave").val("");
	$("#formBuyer")[0].reset();
}

//UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
		{     
	$("#hidBuyerIDSave").val($(this).closest("tr").find('#hidBuyerIDUpdate').val());     
	$("#BuyerCode").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#BuyerName").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#BuyerEmail").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#BuyerContactNumber").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#BuyerAddress").val($(this).closest("tr").find('td:eq(4)').text()); 
	

});


//Remove Operation
$(document).on("click", ".btnRemove", function(event){
	$.ajax(
	{
		url : "BuyerAPI",
		type : "DELETE",
		data : "Buyer ID=" + $(this).data("buyerID"),
		dataType : "text",
		complete : function(response, status)
		{
			onBuyerDeletedComplete(response.responseText, status);
		}
	});
});

function onBuyerDeletedComplete(response, status)
{
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Deleted.");
			$("#alertSuccess").show();
					
			$("#divBuyerGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Deleting.");
		$("#alertError").show();
	}else{
		$("#alertError").text("Unknown Error While Deleting.");
		$("#alertError").show();
	}
}

//CLIENTMODEL
function validateBuyerForm() {  
	// CODE 
	if ($("#BuyerCode").val().trim() == "")  {   
		return "Insert Buyer Code.";  
		
	} 
	
	 // NAME 
	if ($("#BuyerName").val().trim() == "")  {   
		return "Insert Buyer Name.";  
		
	} 
	 
	 // Email 
	if ($("#BuyerEmail").val().trim() == "")  {   
		return "Insert Buyer Email.";  
		
	} 
	 // is  numerical value
	var tmpContactNumber =$("#BuyerContactNumber").val().trim();
	if(!$.isNumeric(tmpContactNumber))
	{   
		return "Insert a numerical value for Buyer Contact Number.";  
		
	 
	}
	// Address  
	if ($("#BuyerAddress").val().trim() == "")  {   
		return "Insert Buyer address.";  
		
	} 
	
 return true; 
	 
  }

