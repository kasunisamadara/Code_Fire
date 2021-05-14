package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;;


@WebServlet("/BuyerAPI")
public class BuyerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Buyer BuyerObj = new Buyer();
	
    public BuyerAPI() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException 
			{ 
			 String output = BuyerObj.insertBuyer(request.getParameter("BuyerCode"), 
			 request.getParameter("BuyerName"), 
			 request.getParameter("BuyerEmail"), 
			 request.getParameter("BuyerContactNumber"),
			 request.getParameter("BuyerAddress")
			 );
			 response.getWriter().write(output); 
			}
	   
	
			
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	private Map<String, String> getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();  
		try  {   
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");   
			String queryString = scanner.hasNext() ?
					scanner.useDelimiter("\\A").next() : "";   
			scanner.close(); 
		 
		  String[] params = queryString.split("&");   
		  for (String param : params)   {
			  String[] p = param.split("=");    
			  map.put(p[0], p[1]);   
		  }  
		  
		}catch (Exception e)  {  
			
		} 
		return map;
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Map<String, String> param = getParasMap(request);
		String result = BuyerObj.updateBuyer(Integer.parseInt(param.get("hidBuyerIDSave").toString()),
				param.get("BuyerCode").toString(),    
		 		param.get("BuyerName").toString(),        
		 		param.get("BuyerEmail").toString(),        
		 	    param.get("BuyerContactNumber").toString(), 
		 		param.get("BuyerAddress").toString());
		 		
		
		response.getWriter().write(result);
	}
      

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Map<String, String> param = getParasMap(request);
		
		String result = BuyerObj.deleteBuyer(param.get("BuyerID").toString());
		
		response.getWriter().write(result);
	}
	
	

}
