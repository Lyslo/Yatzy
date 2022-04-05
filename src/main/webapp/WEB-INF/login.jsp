<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>login</title>
</head>
<body>
	<div class="container">
        
        <h2>Login</h2><br>
        
        <form action="login" method="post">
        
        	<p>
				<font color="red">${FEILMELDING}</font>
			</p>
        
	        <input type="text" placeholder="Email" name="epost" required><br>
	        
	        <input type="password" placeholder="Password" name="passord" required><br>
	        
	        <button type="submit">Login</button><br>
        
        </form>
        
        <h5>Or</h5>
        
        
        <form action="registrer" method="get">
        
        	<button type="submit">Register</button>
        	
    	</form>
    	
    	
    </div>
</body>
</html>