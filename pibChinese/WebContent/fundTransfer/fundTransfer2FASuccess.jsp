<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>&#20266;&#38134;&#34892;&#20010;&#20154;&#32593;&#19978;&#38134;&#34892;</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Tom@Lwis (http://www.lwis.net/free-css-drop-down-menu/)" />
<meta name="keywords" content="css, dropdowns, dropdown menu, drop-down, menu, navigation, nav, horizontal, vertical left-to-right, vertical right-to-left, horizontal linear, horizontal upwards, cross browser, internet explorer, ie, firefox, safari, opera, browser, lwis" />
<meta name="description" content="Simple vertical left-to-right direction css drop-down menu demo using clean, standards-friendly, free, easy, cross browser framework for css drop-down menus" />
<link href="/pibChinese/asset/secured/helper.css" media="screen" rel="stylesheet" type="text/css" />

<style type="text/css">

/* Layout */
@import "/pibChinese/asset/secured/dropdown.css";
@import "/pibChinese/asset/secured/dropdown.vertical.css";

/* Theme */
@import "/pibChinese/asset/secured/default.css";

</style>


</head>
<body>
<div id="wrap">  <!-- This wrap div needs to encompass everything except the footer div at bottom -->
<h1>&#27426;&#36814;&#26469;&#21040;&#20266;&#38134;&#34892;&#20010;&#20154;&#32593;&#19978;&#38134;&#34892;</h1>

<ul id="nav" class="dropdown dropdown-vertical">
    <li><a href="/pibChinese/Landing2FA">&#39318;&#39029;</a></li>
    <li class="dir">&#24080;&#25143;&#36164;&#26009;
        <ul>
            <li><a href="/pibChinese/AccountEnquiry2FA">&#24080;&#25143;&#25688;&#35201;</a></li>
            <li><a href="/pibChinese/ViewOnlineActivity">&#32593;&#19978;&#27963;&#21160;&#21382;&#21490;</a></li>
            <li class="dir"><a href="./">&#31649;&#29702;&#25105;&#30340;&#24080;&#25143;</a>
                <ul>
                    <li><a href="./">&#24080;&#25143;&#25688;&#35201;&#35270;&#22270;</a></li>
                    <li><a href="./">&#24080;&#25143;&#21035;&#21517;</a></li>
                    <li><a href="./">&#36830;&#32467;&#24080;&#25143;</a></li>
                    <li><a href="./">&#33073;&#38057;&#24080;&#25143;</a></li>
                    <li><a href="./">&#25903;&#31080;&#29366;&#24577;&#26597;&#35810;</a></li>
                </ul>
            </li>
        </ul>
    </li>
    <li class="dir">&#36716;&#24080;
        <ul>
            <li><a href="/pibChinese/AddPayee2FA1">&#28155;&#21152;&#25910;&#27454;&#20154;</a></li>
            <li><a href="./">&#31649;&#29702;&#25910;&#27454;&#20154;</a></li>
            <li><a href="/pibChinese/FundTransfer2FA1">&#20351;&#36716;&#31227;</a></li>
        </ul>
    </li>
    <li class="dir">&#26597;&#30475;&#20215;&#26684;
        <ul>
            <li><a href="./">&#21333;&#20301;&#20449;&#25176;&#22522;&#37329;&#20215;&#26684;</a></li>  
            <li><a href="./">&#22806;&#27719;&#27719;&#29575;</a></li>
            <li><a href="./">&#40644;&#37329;&#21644;&#30333;&#38134;&#20215;&#26684;</a></li>
        </ul>
    </li>
    <li class="dir">&#23458;&#25143;&#26381;&#21153;</a>
        <ul>
            <li><a href="/pibChinese/ChangePassword2FA">&#26356;&#25913;&#23494;&#30721;</a></li>
        </ul>
    </li>
    <li><a href="/pibChinese/Logout">&#30331;&#20986;</a></li>
</ul>
	<div id="main">
	
	
	
			<%  String from  = (String) request.getAttribute("fromAccount");
			  	String to  = (String) request.getAttribute("toAccount");
			  	String amount  = (String) request.getAttribute("amount");%>
			   <br></br>	
			   <label>
			   &#36716;&#36134;&#25104;&#21151;&#12290;
			   </label>
			   <br /><br>
			   </br>
			<label>&#26469;&#33258;&#65306; Uniplus <%=from %></label>
			<br></br>
			<label>&#21435;&#24448;&#65306; Uniplus <%=to %></label>
			  <br></br>
			  <label>&#37329;&#39069;&#65306; <%=amount %></label>
			  <br></br>
	
	
	
	
	</div>

</div>

<div class="footer">
	<div id="foot"> <!-- this extra div is just centering the fixed width area of the footer content -->

    <p>&#29256;&#26435;&#25152;&#26377;&#169;2011&#20266;&#38134;&#34892;&#12290;&#20445;&#30041;&#25152;&#26377;&#26435;&#21033;&#12290;</p>
    </div>
</div>

</body>


</html>