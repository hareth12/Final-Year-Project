
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<title>UOB</title>

    <link href="_css/index.css" rel="stylesheet" type="text/css" media="screen, projection"/> 
    <script type="text/javascript" src="_scripts/mootools.js"></script> 
	<script type="text/javascript" src="_scripts/all.js"></script>

</head>

<body>

	<div id="wrapper">

		<div id="mainContent"> 
            <img src="_assets/_images/soar.jpg" class="imgOverlayWidth" alt="soar"/> 
            
            <div id="language">
           	 <form method="post" action="/chinese/Index">
            	<select name="language" onchange='this.form.submit()'>
				  <option value="english">English</option>
				  <option value="chinese">&#20013;&#25991;</option>
				</select>
				</form>
            </div>
            
            <div id="logo"> 
                <img src="_assets/_images/logo.gif" alt="United Overseas Bank"/> 
            </div> 
            <div id="textSoar"> 
                <img src="_assets/_images/text-soar.png" alt="text-soar"/> 
            </div> 
            <div id="horNavBar">

                <ul>

                    <li><a href="/fyp2/Login1FA" class="holder">Personal Internet Banking</a></li>

                    <li><a href="vertBar.html" class="holder">Private Banking</a></li>

                    <li><a href="vertBar.html" class="holder">Privilege Banking & Privilege Reserve</a></li>
                    
                    <li><a href="vertBar.html" class="holder">Corporate & Institutional Banking</a></li>
                    
                    <li><a href="vertBar.html" class="holder">Business Banking</a></li>

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