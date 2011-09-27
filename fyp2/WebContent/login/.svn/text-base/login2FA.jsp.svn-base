
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<title>UOB:Personal Internet Banking</title>

    <link href="_css/login.css" rel="stylesheet" type="text/css" media="screen, projection"/> 
    <script type="text/javascript" src="_scripts/mootools.js"></script> 
	<script type="text/javascript" src="_scripts/all.js"></script>

</head>

<body>

	<div id="wrapper">

		<div id="mainContent"> 
            <img src="_assets/_images/soar.jpg" class="imgOverlayWidth" alt="soar"/> 
            <div id="logo"> 
                <img src="_assets/_images/logo.gif" alt="United Overseas Bank"/> 
            </div> 
             <div id = "logout">
            	<ul>
            	<li><a href="/fyp2/Logout" class="current">Logout </a></li>
            	</ul>
            </div>           
            <div id = "loginForm2FA">
            
			<form id="form1" name="form1" method="post" action="/fyp2/Login2FAAction"">
			    <p>
			      
			      <%=((String)request.getAttribute("preHash")) %> -
			     
			      <label>
			        <input type="password" name="hash2FA" id="hash2FA" />
			      </label>
			      <label>
			        <input type="submit" name="login" id="login" value="Login" />
			      </label>
			      <label>
			      	<input type="hidden" value=<%= (String)request.getAttribute("userName")%> id="userName" name="userName" />     
			      </label>
			     <br></br>
				      Please enter the 2FA code that has been  
				 <br></br>
				      sent to your registered phone number.
			    </p>
			  </form>
            
            
            </div>
            
            <div id="horNavBar">

                <ul>

                    <li><a href="/fyp2/Login1FA" class="current">Personal Internet Banking</a></li>

                </ul>	

            </div>

  		</div>     

     	<div id="footer">

   		  <table width="100%" border="0">

          		<tr>

    				<td align="left"><p><a href="#">Privacy Statement</a> 

                    	| <a href="#">Terms of Use</a></p></td>

    				<td align="right"><p>&copy; 2011 United Overseas Bank</p></td>

  				</tr>

			</table>

  		</div>    

	</div> 
    <script type=text/javascript> 
		window.addEvents({
    		load: function(){
        		a = new resizeWindow(0);
    		},
    		resize: function(){
        		a.resizeFunc();
    		}
		});
	</script>        

</body>

</html>