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
		type : t,
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
	$("#Buyer Code").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#Buyer Name").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#Buyer Email").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#Buyer Contact number").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#Buyer Address").val($(this).closest("tr").find('td:eq(4)').text()); 
	

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
	if ($("#Buyer Code").val().trim() == "")  {   
		return "Insert Buyer Code.";  
		
	} 
	
	 // NAME 
	if ($("#Buyer Name").val().trim() == "")  {   
		return "Insert Buyer Name.";  
		
	} 
	 
	 // Email 
	if ($("#Buyer Email").val().trim() == "")  {   
		return "Insert Buyer Email.";  
		
	} 
	 // is  numerical value
	var tmpContactNumber =$("#Buyer Contact Number").val().trim();
	if(!$.isNumeric(tmpContactNumber))
	{   
		return "Insert a numerical value for Buyer Contact Number.";  
		
	 
	}
	// Address  
	if ($("#Buyer Address").val().trim() == "")  {   
		return "Insert Buyer address.";  
		
	} 
	
 return true; 
	 
  }

