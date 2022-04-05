<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="10">
<link rel="stylesheet" href="styles.css">
<title>Yatzy</title>
</head>
<body>
	<div class="game">
        
        <h1>Yatzy</h1><br>
        <h2>Winner: ${spill.winner()}</h2>
        <h5> Spill ID : ${spill.getID()} </h5>
        <p>Aktiv Spiller: ${spill.getAktivSpiller().getBrukernavn()}</p>
        <p>RunderNr: ${spill.getRunderSpilt()}</p>
        
        <hr><br>
        
        <c:if test="${!spill.isFerdig()}">
       
      
	        <img src="img/face${spiller.getHand()[0]}.png">
	        <img src="img/face${spiller.getHand()[1]}.png">
	        <img src="img/face${spiller.getHand()[2]}.png">
	        <img src="img/face${spiller.getHand()[3]}.png">
	        <img src="img/face${spiller.getHand()[4]}.png">
	
			<c:if test="${sessionScope.spiller.getEpost().equals(spill.getAktivSpiller().getEpost())}">
	        
	        <h4>Select the dice you want to reroll</h4>
	        
	        <p>Antall kast: ${spiller.getKast()}</p>
	        
				<form action="game" method="post">
			
					  <input type="checkbox" id="t1" name="t1" value="t1" >
					  <input type="checkbox" id="t2" name="t2" value="t2" >
					  <input type="checkbox" id="t3" name="t3" value="t3" >
					  <input type="checkbox" id="t4" name="t4" value="t4" >
					  <input type="checkbox" id="t5" name="t5" value="t5" >
					  
					  <br>
					  
					  <button type="submit">Roll Dice</button>
				</form>
			</c:if>
			
		</c:if>
		
		<c:if test="${spill.isFerdig()}">
			<h3>Spillet er ferdig, ${spill.winner()} har vunnet! </h3>
			
			<form action="browse" method="get">
	        
	        <button type="submit" name="leave" value="leave">Browse</button><br>
        
        </form>
		
		</c:if>
		
		
        
        
        <table width="482">
        <tbody>
        
        <tr>
        <td width="98"><strong>Players:</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getBrukernavn()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Aces</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getEnere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Twos</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getToere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Threes</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getTrere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Fours</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getFirere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Fives</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getFemmere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Sixes</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSeksere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>SUM</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().ovrepoengsum()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>BONUS</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().bonus()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>One pair</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get1Par()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Two pair</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get2Par()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>3 of a kind</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get3Like()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>4 of a kind</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get4Like()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Small straight</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getLiten()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Large straight</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getStor()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Full house</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getHus()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Chance</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSjanse()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Yatzy</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getYatzy()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>TOTAL</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().sluttresultat()}</td>
        </c:forEach>
        </tr>
        
        </tbody>
        </table>

        
    </div>
</body>
</html>