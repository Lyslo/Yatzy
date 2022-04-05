<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="3">
<link rel="stylesheet" href="styles.css">
<title>Browse</title>
</head>
<body>
	<div class="browser">
        
        <h2>Join or create a game</h2><br>
        
        <hr><br>
        
        <form action="waiting" method="post">
		
       		<button type="submit" name="create" value = "new">New game</button>
       		
        </form>
        
        <h3> Spill som ikke har startet</h3>
        <table>
        		
       		 <c:forEach items='${requestScope["ikkeStartet"]}' var="spill">
       		 
	        	<tr class="browserUnit">
		        	<td>
		        		<h3> Spill ID : ${spill.getID()} </h3>
		        		
		            	<p>Players: ${spill.getSpillere().size()}/6</p>
		            	<p>Status: ${spill.status()}</p>
		            
		            
			            <form action="waiting" method="post">
			            
			            	<button type="submit" name="join" value="${spill.getID()}">Join game</button>
			            	
			             </form>
			             
			             <form action="waiting" method="post">
			             
			            	<button type="submit" name="spectate" value="${spill.getID()}">Spectate game</button>
			            	
			            </form>
		            
		        	</td>
	        	</tr>
	        	
        	</c:forEach>
        </table>
        
        <h3> Spill som har startet</h3>
        
        <table>
        
       		 <c:forEach items='${requestScope["startet"]}' var="spill">
       		 
	        	<tr class="browserUnit">
		        	<td>
		        		<h3> Spill ID : ${spill.getID()} </h3>
		        		
		            	<p>Players: ${spill.getSpillere().size()}/6</p>
		            	<p>Status: ${spill.status()}</p>
			             
			             <form action="waiting" method="post">
			             
			            	<button type="submit" name="spectate" value="${spill.getID()}">Spectate game</button>
			            	
			            </form>
		            
		        	</td>
	        	</tr>
	        	
        	</c:forEach>
        </table>
 
    </div>
</body>
</html>