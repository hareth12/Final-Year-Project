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
<h1>Welcome to Pseudo Bank Personal Internet Banking</h1>

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
	
	
<strong> You have either key in the wrong password or your new passwords do not match.</strong>

	<form name="input" action="/pib/ChangePassword1FA2" method="post">
		Old Password: <input type="password" name="oldPassword" />  <br></br>
		New Password: <input type="password" name="newPassword1" /> <br></br>
		Repeat Password: <input type="password" name="newPassword2" /> <br></br>
		<input type="submit" value="Submit" />
		</form>



</div>

</div>

	<div class="footer">
		<div id="foot"> <!-- this extra div is just centering the fixed width area of the footer content -->
	        <p>Copyright &copy; 2011 Pseudo Bank. All rights reserved.</p>
	    </div>
	</div>
</body>
</html>