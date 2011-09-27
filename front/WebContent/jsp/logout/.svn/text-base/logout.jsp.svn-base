<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr">

      <head>
            <META HTTP-EQUIV="Pragma" CONTENT="no-cache"/> 
            <META HTTP-EQUIV="Expires" CONTENT="-1"/> 
            <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE,NO-STORE"/>



<title>UOB Personal Internet Banking</title><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/reset.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/global_en.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/mass_en.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/thickbox.css"><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/jquery-1.3.2.min.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/swfobject.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/pib_tooltip.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/PIBValidation.js" type="text/javascript"></script>



<!--[if IE]>
<link href="/front/PIBLogin/framework/skins/PIBMass/assets/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 6]>
<link href="/front/PIBLogin/framework/skins/PIBMass/assets/css/ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript">
var encString='';
var isFirstReq = true;
    var  loginAction ;
    

    
    
        function chkWindowClose()
{
  if(isFirstReq){
    if('afterLogin'==loginAction){
window.location.replace("/front/PIBLogin/appmanager/Login/1FA?_nfpb=true&_nfls=false&_pageLabel=SECSEC05") ;
    }
 }          
}
    
    
    
    
function e2eValidateSubmit (validateFlag,e2eFlag,actionUrl){
    if(validateFlag){

        e2esubmit(e2eFlag,actionUrl);
    } 
    else {

        return false;
    }
} 
        
function e2esubmit(e2eFlag,actionUrl){
    if(checkSubmitAction()){
        isFirstReq = false;
        if(e2eFlag) {
            
            document.forms[1].action=actionUrl;
            document.forms[1].submit();
        
        }else {
            document.forms[0].action=actionUrl;
            document.forms[0].submit();
        }
    }
    else {
        return false;
    }
}

function setSubmitVal(){
    if(!checkSubmitAction()){
        return false;
    }
    else {
        isFirstReq = false;
    }
}



function checkSubmitAction(){
    if(isFirstReq){
        return true;
    }
    else {
        return false;
    }
}


function encryptForm(challenge,pubKey)
{
    
    var inputFields=document.forms[0].elements;
    
    for (var i=0;i<inputFields.length;i++) 
    {    
        if (inputFields[i].name)
        {
            
            var key=inputFields[i].name;
            var value=inputFields[i].value;
            var strName=key.replace(':','%7C');
            var strValue=value.replace(':','%7C');
            
            if((inputFields[i].type == 'checkbox' || inputFields[i].type == 'radio'))
            {
                if(inputFields[i].checked)
                {
                    document.e2eApplet.addParameter(strName,strValue);
                }
            } else {
            
                document.e2eApplet.addParameter(strName,strValue);
            }
        }
    }
    
    
    generateDesKeyandParamString(challenge,pubKey);   
    

 }
 
 
 function generateDesKeyandParamString(challenge,pubKey)
{

    var inputElm=document.forms[1].elements;

    for(var k=0;k<inputElm.length;k++)
    {
        if(inputElm[k].id=='challengeDesKey')
        {
            inputElm[k].value = document.e2eApplet.getRSAEncChallengeWithSessKey(challenge,pubKey);
        } else if(inputElm[k].id=='encData')
        {
            inputElm[k].value = document.e2eApplet.encryptForm(pubKey);

        }
    }
 }
 
 

</script>
</head>

<body onunload="javascript:  chkWindowClose()">




<script type="text/javascript">
    var flashvars = {};
    var lgclked = false;
    var strErrMessage = "Applet not loaded properly! Please reload the page again";
    var params = {};
    params.wmode = "transparent";
    var attributes = {};
    swfobject.embedSWF('/front/PIBLogin/framework/skins/PIBMass/assets/swf/deposit.swf', 'site-flash', '300', '59', '9.0.0', false,flashvars, params, attributes);
    
    
    
    function logClicked(){
    isFirstReq =false;
    if(lgclked){
        return false;
    }
    lgclked = true;
    window.location.href="https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/1FA?_nfpb=true&_nfls=false&_pageLabel=SECSEC03";
    return true;
}
    
    function doLogout(){        
        window.location.href="https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/1FA?_nfpb=true&_nfls=false&_pageLabel=SECSEC03";
    }
    
</script>

<a name="Top"></a>
<div id="bgtop" class="wrapper">
    <div id="header">
        <div id="header-left">
            
                
                    <div id="site-logo-container">
                        <div id="site-logo">
                            <img src='/front/PIBLogin/framework/skins/PIBMass/assets/images/common/uob-logo.jpg'/>
                        </div>
                        <div id="site-welcome">
                            <h3 id="welcome-text">Welcome to UOB</h3>
                        </div>
                        </div>
                        <div id="site-animation">
                            <div id="site-flash"> 
                            <p><a href="http://get.adobe.com/flashplayer"><img src="/front/PIBLogin/framework/skins/PIBMass/assets/images/common/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p> 
                            </div> 
                        </div>
                
            
        </div>
        
        
        
        <div style="clear:both;"></div>
        
    </div>
    









<script>

    if(window.self.name!='' && window.self.name.indexOf('TB_')!=-1){
        window.parent.doLogout();   
        window.self.name="login";   
    }
</script>

<div id="logincontent">
<form action="/front/PIBLogin/appmanager/Login/1FA?_nfpb=true&amp;_windowLabel=logout_1&amp;logout_1_actionOverride=%2Fcom%2Fuob%2Fpib%2Fpageflow%2Flogout%2Flogout&amp;_pageLabel=SECSEC03" method="post">

         
         
<table  class="width-980">
<tr><td class="width-110"></td>
<td>
<table id="table-main">
        <tr>
          <td><table class="width-760">
              <tr>
                
          <td><h1 class="main-title">Logout</h1></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td>
               <table class="table-main width-760">
        <tr> 
          <td colspan="4" class="table-header data-section-header"><div>Thank you for using UOB Personal Internet Banking. For security reasons, please 
          <a href="/personal/ebanking/pib/faq.html?q=clear_disk_cache">clear your browser's disk cache</a> after each session.</div></td>
        </tr>
    
        <tr> 
          <td class="row-alt width-80 formTextBold"><div>Login</div></td>
          <td class="row-alt width-260 formText"><div><span>12&#58;36 AM 09 Sep 2011</span> (Singapore 
            Time)</div></td>
          <td class="row-alt width-80 formTextBold"><div>Logout</div></td>
          <td class="row-alt width-260 formText"><div><span>12&#58;38 AM 09 Sep 2011</span> (Singapore 
            Time)</div></td>
        </tr>
        <tr> 
          <td class="row-alt formTextBold"><div>Duration</div></td>
          <td colspan="3" class="row-alt formText"><div><span>1</span> minute(s)</div></td>
        </tr>
    <tr>
    <td colspan="4" class="row-whitebg">
        <table class="table-sub">
            <tr>
                <td>
                    <div>
                        <table class="table-sub">
                            <tr>
                            <td colspan="3">
                                <div align="right" class="button-alignL">
                                <a href="http://www.uob.com.sg/personal/index.html"><img src="/front/PIBLogin/framework/skins/PIBMass/assets/images/common/buttons_pib/btn_uobhome.gif" width="131" height="20" border="0" ></a> 
                                </div>
                                    
                                        
                                        
                                <div class="modal-2FA">
                                <h3>Return to UOB Personal Internet Banking Login Screen<br>
                                    </h3>
                                <div>
                    
                                <div class="button-alignR">
                                <a href="/front/PIBLogin/appmanager/Login/Public"><img src="/front/PIBLogin/framework/skins/PIBMass/assets/images/common/buttons_pib/mass/btn_proceed.gif" width="131" height="20" border="0" ></a> 
        
                                </div>
                    
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                                        
                                        
                                        
                                        
                                    
                                </td>
                            </tr>
                            <tr><td width="5%">&nbsp;</td>
                                <td align="center"><a href="https://uniservices1.uobgroup.com/secure/forms/pib_online_survey.jsp" target="_new" >
                                        <img src="/front/online_services/pib/assets/images/surveybanner.jpg"  width="715" height="94" align="middle"> 
                                    </a> </td>
                                <td width="5%">&nbsp;</td>
                            </tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>                            
                        </table>
                    </div>

                </td>
            </tr>
        </table>
    </td>           
</tr>
      </table>
      
          </td>
        </tr>
      </table>
      </td>
      <td class="width-110"></td>
      </tr>
      </table>
</form>
</div>



<div id="footerNbg" class="wrapper">
<div id="footer-links">
        <div id="footer-privacy">
        <a href="http://www.uobgroup.com/privacy/index.html" target="Privacy">Privacy & Security</a>
        </div>
        <div id="footer-moreinfo">
        <a href="http://www.uobgroup.com/important/index.html" target="More">More Information</a> | 
        </div>
        <div id="footer-tnc">
        <a href="http://www.uob.com.sg/assets/pdfs/personal/ebanking/pubtnc.pdf" target="Terms">Terms & Conditions</a> | 
        </div>
        <ul>
            <li><a href="http://www.uobgroup.com/about/careers/why_join_uob/make_your_mark.html" target="Careers">Careers</a> |</li>
            <li><a href="http://www.uobgroup.com/contact/index.html" target="Contact">Contact Us</a> |</li>
            <li><a href="http://www.uobgroup.com/help/index.html" target="Help">Help</a> |</li>
            <li><a href="http://www.uobgroup.com/search/search.html" target="Search">Search</a> |</li>
            <li><a href="http://www.uobgroup.com/sitemap/index.html" target="Sitemap">Sitemap</a> |</li>
            <li><a href="http://www.uobgroup.com/other_uob_sites/index.html" target="Other UOB Sites">Other UOB Sites</a> </li>
        </ul>
    </div>
    <div id="footer-copyright">
        Copyright © 2010 United Overseas Bank Limited Co. Reg. No. 193500026Z. All Rights Reserved.     
    </div>
</div>
</body></html>