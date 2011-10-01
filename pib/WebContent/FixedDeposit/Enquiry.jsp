<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Pseudo Bank Personal Internal Banking</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Tom@Lwis (http://www.lwis.net/free-css-drop-down-menu/)" />
<meta name="keywords" content="css, dropdowns, dropdown menu, drop-down, menu, navigation, nav, horizontal, vertical left-to-right, vertical right-to-left, horizontal linear, horizontal upwards, cross browser, internet explorer, ie, firefox, safari, opera, browser, lwis" />
<meta name="description" content="Simple vertical left-to-right direction css drop-down menu demo using clean, standards-friendly, free, easy, cross browser framework for css drop-down menus" />
<link href="/pib/asset/secured/helper.css" media="screen" rel="stylesheet" type="text/css" />

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
<h1>Welcome to Pseudo Bank Personal Internal Banking</h1>

<ul id="nav" class="dropdown dropdown-vertical">
    <li><a href="/pib/Landing2FA">Home</a></li>
    <li class="dir">Account Information
        <ul>
            <li><a href="/pib/AccountEnquiry2FA">Account Summary</a></li>
            <li><a href="/pib/ViewOnlineActivity">Online Activity History</a></li>
            <li class="dir"><a href="./">Manage My Accounts</a>
                <ul>
                    <li><a href="./">Account Summary View</a></li>
                    <li><a href="./">Account Alias</a></li>
                    <li><a href="./">Link Accounts</a></li>
                    <li><a href="./">Delink Accounts</a></li>
                    <li><a href="./">Cheuque Status Enquiry</a></li>
                </ul>
            </li>
        </ul>
    </li>
    <li class="dir">Funds Transfer
        <ul>
            <li><a href="/pib/AddPayee2FA1">Add Payee</a></li>
            <li><a href="./">Manage Payees</a></li>
            <li><a href="/pib/FundTransfer2FA1">Make Transfer</a></li>
        </ul>
    </li>
     <li class="dir">Fixed Deposit
        <ul>
            <li><a href="/pib/FDEnquiry1">Enquiry</a></li>
            <li><a href="/pib/FDTransfer1">Transfer Fund</a></li>
            <li><a href="/pib/FDMakePlacemen1">Make Placement</a></li>
        </ul>
    </li>    
    <li class="dir">View Rates
        <ul>
            <li><a href="./">View Unit Trust Prices</a></li>  
            <li><a href="./">View Foreign Exchange Rates</a></li>
            <li><a href="./">View Gold & Silver Rates</a></li>
        </ul>
    </li>
    <li class="dir">Customer Service</a>
        <ul>
            <li><a href="/pib/ChangePassword2FA">Change Password</a></li>
        </ul>
    </li>
    <li><a href="/pib/Logout">Logout</a></li>
</ul>
	<div id="main">
	<strong>Fixed Deposit Account</strong>
	
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