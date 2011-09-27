<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>UOB</title>
    <link href="_css/login.css" rel="stylesheet" type="text/css" media="screen, projection"/>
    <script type="text/javascript" src="_scripts/mootools.js"></script>
	<script type="text/javascript" src="_scripts/all.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="mainContent">
            <img src="_assets/_images/soar.jpg" class="imgOverlayWidth" alt="Soar"/>
            <div id="logo">
                <img src="_assets/_images/logo.gif" alt="United Overseas Bank"/>
            </div>
            <div id="horNavBar">
                <ul>
                    <li><a href="vertBar.html" class="current">Personal Internet Banking</a></li>
                </ul>	
            </div>
             <div id = "logout">
            	<ul>
            	<li><a href="/fyp2/Logout" class="current">Logout </a></li>
            	</ul>
            </div>
 
            <div id="vertNavBar">
                <ul>
                    <li><a href="/fyp2/Welcome1FA" class="holder">Enquiry Mode</a></li>
                    <li><a href="/fyp2/Login2FA" class="holder">Full Access Mode</a></li>
               
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