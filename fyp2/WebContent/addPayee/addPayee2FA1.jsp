<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>UOB: Personal Internet Banking</title>
    <link href="_css/welcome.css" rel="stylesheet" type="text/css" media="screen, projection"/>
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
            <div id="vertNavBar">
                <ul>
                    <li><a href="/fyp2/AccountEnquiry2FA" class="holder">Account Enquiry</a></li>
                    <li><a href="/fyp2/AddPayee2FA1" class="current">Add Payee</a></li>  
                    <li><a href="/fyp2/FundTransfer2FA1" class="holder">Transfer Fund</a></li>   
                </ul>	
            </div>
           <div id = "logout">
            	<ul>
            	<li><a href="/fyp2/Logout" class="current">Logout </a></li>
            	</ul>
            </div>
            
            <div id="DisplayBar">
            		<jsp:scriptlet> String[][] y = (String[][])request.getAttribute("accounts");  </jsp:scriptlet>
					   <form id="form1" name="form1" method="post" action="/fyp2/AddPayee2FA1Action"">
					   <form action="">
					   <p>
				   		<label>Select an account to transfer from: </label>
				   		<%int i =0;
				   			out.println(" <select name=\"fromAccount\">");
				   			while(y[i][0]!=null){
				   				out.println("<option value=\""+y[i][1]+"\">"+ y[i][0]+" "+y[i][1]+"</option>");
				   				i++;
				   			}
				   			out.println("</select>");
				   		 %>
						<br></br>
					
						<label>
				        <input type="submit" name="select" id="select" value="Select" />
				      </label>
					</p>	
						</form>
				  </form> 
            
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