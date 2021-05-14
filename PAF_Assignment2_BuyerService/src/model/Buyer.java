package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 

public class Buyer {


//A common method to connect to the DB
   private Connection connect() 
     { 
       Connection con = null; 
   try
     { 
     Class.forName("com.mysql.cj.jdbc.Driver"); 

      //Provide the correct details: DBServer/DBName, username, password 
     con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer", "root", ""); 
     
     System.out.println("sucessfully connected");
     } 
    catch (Exception e) 
    {e.printStackTrace();} 
     return con; 
    } 
   
   public String insertBuyer(String code, String name, String email, String contactNumber, String address) 
   { 
     String output = ""; 
     try
    { 
     Connection con = connect(); 
     if (con == null) 
     {
   	  return "Error while connecting to the database for inserting."; 
      }
     
     // create a prepared statement
     
     String query = " insert into Buyer (`Buyer ID`,`Buyer Code`,`Buyer Name`,`Buyer Email`,`Buyer Contact Number`,`Buyer Address`)"+ " values (?, ?, ?, ?, ?, ?)"; 
     PreparedStatement preparedStmt = con.prepareStatement(query); 
     
    // binding values
    preparedStmt.setInt(1, 0); 
    preparedStmt.setString(2, code); 
    preparedStmt.setString(3, name); 
    preparedStmt.setString(4, email); 
    preparedStmt.setString(5,contactNumber); 
    preparedStmt.setString(6,address);
    
   
   // execute the statement3
   preparedStmt.execute(); 
   //System.out.println("3");
   con.close(); 
   

	//Create JSON Object to show successful msg.
	String newBuyer = readBuyer();
	output = "{\"status\":\"success\", \"data\": \"" + newBuyer + "\"}";
   } 
   catch (Exception e) 
   { 
	 //Create JSON Object to show Error msg.
		output = "{\"status\":\"error\", \"data\": \"Error while Inserting Buyer.\"}";   
		System.err.println(e.getMessage());  
   //System.err.println(e.getMessage()); 
   } 
   return output; 
} 
   
   
   public String readBuyer() 
{ 
   String output = ""; 
   
   try{ 
       Connection con = connect(); 
       if (con == null) {
           	return "Error while connecting to the database for reading."; 
} 
  
//Prepare the html table to be displayed
  output = "<table border='1'><tr><th>Buyer Code</th><th>Buyer Name</th>" + "<th>Buyer Email</th>" + "<th>Buyer Contact Number</th>" +"<th>Buyer Address</th>" +"<th>Update</th><th>Remove</th></tr>"; 

   String query = "select * from buyer"; 
   Statement stmt = con.createStatement(); 
   ResultSet rs = stmt.executeQuery(query); 
   
  // System.out.println("5");
  // iterate through the rows in the result set
   while (rs.next()) 
{ 
   String BuyerID = Integer.toString(rs.getInt("Buyer ID")); 
   String BuyerCode = rs.getString("Buyer Code"); 
   String BuyerName = rs.getString("Buyer Name");
   String BuyerEmail = rs.getString("Buyer Email");
   String BuyerContactNumber = rs.getString("Buyer Contact Number"); 
   String BuyerAddress = rs.getString("Buyer Address"); 
   
   
  
    // Add into the html table
   
    output += "<td>"  + BuyerCode + "</td>"; 
    output += "<td>" + BuyerName + "</td>"; 
    output += "<td>" + BuyerEmail + "</td>"; 
    output += "<td>" + BuyerContactNumber + "</td>"; 
    output += "<td>" + BuyerAddress +"</td>";
    
   
    
   // buttons
    output += "<td><input name='btnUpdate' type='button' value='Update' "
    		+ "class='btnUpdate btn btn-secondary' data-itemid='" + BuyerID + "'></td>"
    		+ "<td><input name='btnRemove' type='button' value='Remove' "
    		+ "class='btnRemove btn btn-danger' data-itemid='" + BuyerID + "'></td></tr>"; 
    		 
 } 
   con.close(); 
   // Complete the html table
   output += "</table>"; 
 } 
   catch (Exception e) 
 { 
   output = "Error while reading Buyer."; 
   e.printStackTrace();
   //System.err.println(e.getMessage());  
 } 
   return output; 
 } 
   
   
   public String updateBuyer(int ID, String code, String name, String email, String contactNum, String address)
   { 
    String output = ""; 
    try
  { 
  Connection con = connect(); 
  if (con == null) 
 {
	return "Error while connecting to the database for updating."; 
	
	} 
  
  
   //create a prepared statement
   String query = "UPDATE Buyer SET `Buyer Code`=?,`Buyer Name`=?,`Buyer Email`=?,`Buyer Contact Number`=?,`Buyer Address`=? WHERE `Buyer ID`=?"; 
   PreparedStatement preparedStmt = con.prepareStatement(query); 
   
   
   
   //binding values
   preparedStmt.setString(1, code); 
   preparedStmt.setString(2, name);
   preparedStmt.setString(3, email); 
   preparedStmt.setString(4,contactNum); 
   preparedStmt.setString(5, address); 
   preparedStmt.setInt(6, ID); 
   
    // execute the statement
   preparedStmt.execute(); 
   
  
   con.close(); 
 //create JSON object to show successful msg
   String newBuyer = readBuyer();
   output = "{\"status\":\"success\", \"data\": \"" + newBuyer + "\"}";
   } 
   catch (Exception e) 
   { 
	   output = "{\"status\":\"error\", \"data\": \"Error while Updating Buyer Details\"}";      
   e.printStackTrace();
   //System.err.println(e.getMessage()); 
   } 
   return output; 
   } 
   
   
   public String deleteBuyer(String BuyerID) 
   { 
        String output = ""; 
      try
       { 
         Connection con = connect(); 
         if (con == null) 
       {
	       return "Error while connecting to the database for deleting."; 
        } 
    
    // create a prepared statement
       String query = "delete from Buyer where `Buyer ID`=?"; 
       PreparedStatement preparedStmt = con.prepareStatement(query); 
       
      
    // binding values
       preparedStmt.setInt(1, Integer.parseInt(BuyerID));
       
      
      // execute the statement
       preparedStmt.execute(); 
       con.close(); 
       

		  //create JSON Object
	   String newBuyer = readBuyer();
      
       output = "{\"status\":\"success\", \"data\": \"" + newBuyer + "\"}";
        } 
       catch (Exception e) 
      
   { 
    	   output = "{\"status\":\"error\", \"data\": \"Error while Deleting Buyer.\"}";
           e.printStackTrace();
       //System.err.println(e.getMessage());
  } 
      
   return output;
}


  
}
