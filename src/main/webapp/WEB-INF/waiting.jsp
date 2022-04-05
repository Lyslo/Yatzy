<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="3">
<link rel="stylesheet" href="styles.css">
<title>Yatzy</title>
</head>
<body>
	<div class="container">
        
        <h2>Waiting for players</h2><br>
    
        <hr><br>
         
         	<h3> Spill ID : ${spill.getID()} </h3>
         	
	        <h1>Players: ${spill.getSpillere().size()}/6</h1>
	        
	        <c:forEach items='${spill.getSpillere()}' var="spiller">
	       		<p>${spiller.getBrukernavn()}</p>
	        </c:forEach>
	        
	        <p>Admin: ${spill.getAdmin().getBrukernavn()}</p>
	        <p>Status: ${spill.status()}</p>
	        
	        <c:if test="${sessionScope.admin != null}">
		        <form action="waiting" method="post">
		        	<button type="submit" name="start" value="start">Start game</button>
	    		</form>
    		</c:if>
    </div>
</body>
</html>