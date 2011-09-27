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
        
        
        <div id="header-right">
        You are logged into a secured environment.
            <div class="button-alignR">
                <div>
                        <button type="submit" class="button-alignR btnLogout" value=" " onclick="return logClicked();doLogout();"> </button>
                </div>
            </div>
        </div>
    
        
        <div style="clear:both;"></div>
        
    </div>
    










<script type="text/javascript" src="/front/PIBLogin/framework/skins/PIBMass/assets/js/thickbox.js"></script>

<style>.vert-align-middle {vertical-align:middle;}</style>
<style>.vert-align-top {vertical-align:top;}</style>


<div id="logincontent">
<form id="form1" name="form1" method="post" action="/front/Login2FAAction"">
<table  class="width-980">
    <tr>
        <td  class="width-110"></td>
        <td>
            <table id="table-main">
                <tr>
                    <td>
                        <table class="width-760">
                            <tr>
                                <td>
                                    <h1 class="main-title">Full Access Mode<a href="https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/1FA/com/uob/pib/pageflow/common/modulardemo/processOpenDemoPage.do?source=frame&token=05408f2ad2079592f49a4d3b379d3fc3&keepThis=true&_pageLabel=SECSEC02&DEMO_ID=SMS_PAGE&TB_iframe=true&width=806&height=511" id="null" class="thickbox" title="Demo"><img src='/front/PIBLogin/framework/skins/PIBMass/assets/images/common/icon/btn-demo.gif'  alt="Demo"  title="Demo"  width="70px" height="20px" style="padding-top:1px;padding-left:3px;"/></a></h1>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td class="width-110"></td> 
                </tr>
        </table>
        </td></tr></table>
        <div class="width-760">
            <div id="genricErrorDiv"  style="display:none"> <table width="100%" border="0" cellpadding="5" cellspacing="0" > <tr> <td class='width-110'></td>  <td class='width-110'></td>  </tr></table></div>
        </div>
        <table  class="width-980">
            <tr><td class="width-110"></td>                 
                    <td>
                        <table id="table-main6" class="width-760">
                            <tr>
                                <td  class="table-header data-group-header"><div>Authorisation of <b>Full Access Mode</b> via SMS One-Time Password (SMS-OTP)</div></td>
                            </tr>
                            <tr>
                                <td  class="row-alt formText"><div>You should be receiving your SMS-OTP on your registered mobile phone. To continue, please enter your SMS-OTP and click on "Proceed". If you do not receive your SMS, click <a href="http://www.uobgroup.com.sg/personal/ebanking/microsite/2FA/p_generalFAQ.html#20" target="_blank">here</a> to find out more or click "Get Another SMS-OTP".<br><br>To protect your online account, repeated incorrect submissions of your OTP will disable your access to UOB Personal Internet Banking.</div></td>
                            </tr>
                            <tr>
                                 
                                
                                
                                
                                
                                
                                
                                
                                <td> 
                <table class="table-sub2 width-760">            
                    <tr>
                        <td class="row-main width-60 table-label">
                            <div>SMS-OTP</div>
                        </td>
                        <td class="row-main width-180">
                        <table ><tr><td class="width-50 vert-align-middle">
                            <div class="cell-alignR formText"><span class="formText"><%=((String)request.getAttribute("preHash")) %>&#45;</span>
                            </div>
                            </td>
                            <td><div>
                            <input type="password" name="hash2FA" id="hash2FA" >
                                            
                            &nbsp;<img id="LABEL_SMS_PASSWORD_tooltip5844" src='/front/PIBLogin/framework/skins/PIBMass/assets/images/common/buttons_pib/btn_help.gif' onmouseover="xstooltip_show('LABEL_SMS_PASSWORD_div5844', 'LABEL_SMS_PASSWORD_tooltip5844', 50, 25);"  onmouseout="xstooltip_hide('LABEL_SMS_PASSWORD_div5844');" /> <div id="LABEL_SMS_PASSWORD_div5844" class="xstooltip">Please enter the SMS-OTP sent to your mobile phone to proceed.</div></div> 
                            </td></tr>
                            </table>
                        </td>
                        <td class="row-main width-320">
                            <div>System Request Time:
                                        <span>11&#58;47PM 08&#45;Sep&#45;2011</span>&nbsp;(Singapore Time)
                                        <br>Expiry:&nbsp; 
                                        <span>11&#58;50PM 08&#45;Sep&#45;2011</span>&nbsp;(Singapore Time)</div>
                        </td>
                        <td class="row-main cell-radiobutton width-135">
                            <div class="cell-radiobutton">
                                <input type="button" class="button-alignR btnGetAnotherSmsOTP" value=" " onclick="e2esubmit(false,'https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/1FA/pib.c?__c=1f43&amp;token=05408f2ad2079592f49a4d3b379d3fc3');return false;">                         
                            </div>
                        </td>
                     </tr>                  
                </table>
            </td>
                                
                                
                                
                                
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                         
                                <div>   
                                <div>               
                                    <input type="submit" class="button-alignR btnProceed" value=" "> 
                                    </div>
                                </div>
                                <div style="clear:both"></div>
                            </td>
                        </tr>                   
                        <tr class="row-whitebg">                            
                             <td class="row-whitebg" id="imptnotes">
                                <div class="page-notes">
                                    Note:
                                    <ol><li>Receipt of SMS is dependent on your mobile network operator's roaming service. If you are overseas, you may wish to consult them to find out more about the delivery of the SMS to you.</li></ol>                   
                                </div>
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                        <tr class="row-whitebg"> 
                            
                            <td>                 
                                &nbsp;
                            </td>
                        </tr>               
                    </table>
                </td>
                <td class="width-110"></td> 
            </tr>
        </table>
    
</form>
<script language="JavaScript" type="text/JavaScript">
<!--
netui_tagIdNameMap.smsOtpForm="smsOtpForm"
-->
</script>
   
</div>
<div style="clear:both;"></div>
</div>
<script type="text/javascript">
 smsOtpLength ='6';

</script>



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