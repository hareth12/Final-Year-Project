
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<title>&#22823;&#21326;&#38134;&#34892;&#20010;&#20154;&#32593;&#19978;&#38134;&#34892;</title>

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
            	<li><a href="/fyp2/Logout" class="current">&#30331;&#20986; </a></li>
            	</ul>
            </div>           
            <div id = "loginForm2FA">
            
			<form id="form1" name="form1" method="post" action="/chinese/Login2FAAction"">
			    <p>
			      
			      <%=((String)request.getAttribute("preHash")) %> -
			     
			      <label>
			        <input type="password" name="hash2FA" id="hash2FA" />
			      </label>
			      <label>
			        <input type="submit" name="login" id="login" value="&#30331;&#24405;" />
			      </label>
			      <label>
			      	<input type="hidden" value=<%= (String)request.getAttribute("userName")%> id="userName" name="userName" />     
			      </label>
			     <br></br>
				     &#35831;&#36755;&#20837;&#24050;&#21457;&#36865;&#21040;&#24744;&#27880;&#20876;&#30005;&#35805;&#21495;&#30721;&#30340;2FA&#20195;&#30721;&#12290;
			    </p>
			  </form>
            
            
            </div>
            
            <div id="horNavBar">

                <ul>

                    <li><a href="/chinese/Login1FA" class="current">&#36134;&#25143;&#26597;&#35810;</a></li>

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