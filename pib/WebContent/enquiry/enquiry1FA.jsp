<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Pseudo Bank Personal Internal Banking</title>
<link href="/pib/asset/secured/helper.css" media="screen" rel="stylesheet" type="text/css" />
 <link rel="icon" type="image/ico" href="/pib/asset/favicon.ico" />
<style type="text/css">

/* Layout */
@import "/pib/asset/secured/dropdown.css";
@import "/pib/asset/secured/dropdown.vertical.css";

/* Theme */
@import "/pib/asset/secured/default.css";

</style>

</head>
<body>
<div id="wrap">  <!-- This wrap div needs to encompass everything except the footer div at bottom -->
<h1>Welcome to Psuedo Bank Personal Internet Banking</h1>

<ul id="nav" class="dropdown dropdown-vertical">
    <li><a href="/pib/Landing1FA">Home</a></li>
    <li class="dir">Account Information
        <ul>
            <li><a href="/pib/AccountEnquiry1FA">Account Summary</a></li>
            <li class="dir"><a href="./">Manage My Accounts</a>
                <ul>
                    <li><a href="./">Account Summary View</a></li>
                </ul>
            </li>
        </ul>
    </li>
    <li class="dir">View Rates
        <ul>
            <li><a href="/pib/ViewUnitTrust1FA">View Unit Trust Prices</a></li>
            <li><a href="/pib/ViewForex1FA">View Foreign Exchange Rates</a></li>
            <li><a href="/pib/ViewGoldSilver1FA">View Gold & Silver Rates</a></li>
        </ul>
    </li>
    <li class="dir">Customer Service
        <ul>
            <li><a href="/pib/ChangePassword1FA">Change Password</a></li> 
        </ul>
    </li>
    <li><a href="/pib/Logout">Logout</a></li>
</ul>
<div id="main">
		<table style="text-align: center; width: 80%;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
		  <% String[][] x = (String[][])request.getAttribute("records"); %>
		<tr>
		  <td>Account Name</td><td>Account Number</td> <td>Current Balance</td><td>Available Balance</td> 
		</tr>
		
			<% int i = 0;
		while(x[i][0]!=null){
			out.println("<tr>"+
						"<td>"+x[i][0]+"</td><td>"+x[i][1]+"</td><td>"+x[i][2]+"</td><td>"+x[i][3]+
						"</td></tr>");
			i++;			
			}
		 %>
		  </tbody>
		</table>

</div>

</div>

	<div class="footer">
		<div id="foot"> <!-- this extra div is just centering the fixed width area of the footer content -->
	        <p>Copyright &copy; 2011 Pseudo Bank. All rights reserved.</p>
	    </div>
	</div>
</body>
</html>