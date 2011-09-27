<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr">

      <head>
            <META HTTP-EQUIV="Pragma" CONTENT="no-cache"/> 
            <META HTTP-EQUIV="Expires" CONTENT="-1"/> 
            <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE,NO-STORE"/>



<title>FYP Bank Personal Internet Banking</title><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/reset.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/global_en.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/mass_en.css"><link rel="stylesheet" type="text/css" href="/front/PIBLogin/framework/skins/PIBMass/assets/css/thickbox.css"><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/jquery-1.3.2.min.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/swfobject.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/pib_tooltip.js" type="text/javascript"></script><script src="/front/PIBLogin/framework/skins/PIBMass/assets/js/PIBValidation.js" type="text/javascript"></script>


<script type="text/javascript">
var encString='';
var isFirstReq = true;
    var  loginAction ;
    

    
    
        function chkWindowClose()
{
  if(isFirstReq){
    if('afterLogin'==loginAction){
window.location.replace("/PIBLogin/appmanager/Login/1FA?_nfpb=true&_nfls=false&_pageLabel=SECSEC05") ;
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
                            <p><a href="http://get.adobe.com/flashplayer"></a></p> 
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


<div id="logincontent">
<form action="/PIBLogin/appmanager/Login/1FA?_nfpb=true&amp;_windowLabel=SECSEC02&amp;SECSEC02_actionOverride=%2Fcom%2Fuob%2Fpib%2Fpageflow%2Fonefalogon%2FtokenIndex&amp;_pageLabel=SECSEC02" method="post"><input type="hidden" name="reqActionId" id="reqActionId"  value="1315496467965a7252a46">
<table  class="width-980">
<tr><td class="width-110"></td>
<td>
<table id="table-main" class="width-760">
    <tr>

            <td><h1 class="main-title">Login Mode</h1></td>

    </tr>

    
            <tr>
            <td>
            </table>
            </td>
            <td class="width-110"></td>
            </tr>
            </table>
            <div class="width-980" >
                <div >
                        <div id="genricErrorDiv"  style="display:none"> <table width="100%" border="0" cellpadding="5" cellspacing="0" > <tr> <td class='width-110'></td>  <td class='width-110'></td>  </tr></table></div>
                    </div>  
            </div>
            <table  class="width-980">
<table  class="width-980">
<tr><td class="width-110"></td>
<td>
<table id="table-main1" class="width-760">
<tr>
        
             <td class="table-header data-group-header"><div>Please select your login mode. Two-Factor Authentication (2FA) is required for Full Access Mode.</div></td>
             </tr>
                
                <tr> 
                    <td  class="table-header data-section-header">
                        <div>Enquiry Mode</div>
                    </td>
                </tr>
                <tr>
                
                    <td class="table-label width-760">
                        <table id="table-main2 width-760">
                            <tr>
                                <td class="row-alt width-605 formText">
                                    <div>If you login using Enquiry Mode, you can only perform basic balance enquiries. You will NOT have access to full account information or be authorised to perform any other online transactions.</div>
                                </td>
                                <td class="row-alt width-150 cell-chkbox">
                                    <div>
                                        <input type="button" class="button-alignR btnProceed" value=" " onclick="e2esubmit(false,'/front/Welcome1FA');return false;">

                                    </div>
                                </td>           
                            </tr>
                            
                        </table>                        
                    </td>
                </tr>
                
                 
                <tr> 
                    <td class="cell-alignT vert-align-top table-header data-section-header"> 
                        <div>
                        <div class="button-alignL">Full Access Mode
                        </div>
                        <div  class="button-alignL">
                        
                        
                        <a href="https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/1FA/com/uob/pib/pageflow/common/modulardemo/processOpenDemoPage.do?source=frame&token=407f7717d5cf27a712c29fa58072ce5b&keepThis=true&_pageLabel=SECSEC02&DEMO_ID=LOGIN_MODE_SMS_PAGE&TB_iframe=true&width=806&height=511" id="null" class="thickbox" title="Demo"><img src='/front/PIBLogin/framework/skins/PIBMass/assets/images/common/icon/btn-demo.gif'  alt="Demo"  title="Demo"  width="70px" height="20px" style="padding-top:0px;padding-left:3px;"/></a>
                        
                        
                        
                        </div>

                        </div>
                    </td>
                </tr>
                        
                    
                        <tr> 
                            <td class="table-label width-760">
                            <table id="table-main3 width-760">
                            <tr>
                                <td class="table-label width-110 row-alt">
                                    <div align="center">                        
                                        <img src="/front/PIBLogin/framework/skins/PIBMass/assets/images/common/hp.gif">
                                    </div>
                                </td>
                            
                            <td class="formTextBold  width-500 row-alt">
                                <div>SMS-OTP<br> 
                                <span class="formText">Click "Proceed" to receive a One-Time Password (OTP) via your mobile phone.<br>
                                <br>
                                To update your mobile phone number<br>
                                1. Visit any UOB ATM or<br>
                                2. Complete the <a href="http://www.uob.com.sg/assets/pdfs/personal/useful/2FA_registration-update.pdf" target="_blank">2FA Registration/Update Form</a> and mail it to us.</span></div>
                                </td>
                                    
                                    <td class="row-alt width-150 cell-chkbox">
                        <div align="center">    
                        <input type="button" class="button-alignR btnProceed" value=" " onclick="e2esubmit(false,'/front/Login2FA');return false;">
                        </div>
                    </td>   
                    </tr>
                    
                            <tr class="row-whitebg">                        
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr class="row-whitebg">                        
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr class="row-whitebg">                        
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            
                    </table>
                    </td>
                    </tr>           
                                
                 
            
                
            </table>
        </td>
        <td class="width-110"></td>
    </tr>
    
</table>
     
     
</form><div id="duplicate" style="position:absolute; visibility:hidden; z-index:1000;"/><form action="dummy" method="post"><input type="hidden" name="SECSEC02{actionForm.encData}" id="encData"></form>
</div>





<div id="footerNbg" class="wrapper">
<div id="footer-links">
        <div id="footer-privacy">
        <a href="#" target="Privacy">Privacy & Security</a>
        </div>
        <div id="footer-moreinfo">
        <a href="#" target="More">More Information</a> | 
        </div>
        <div id="footer-tnc">
        <a href="#" target="Terms">Terms & Conditions</a> | 
        </div>
        <ul>
            <li><a href="#1Careers" target="Careers">Careers</a> |</li>
            <li><a href="#2Contact Us" target="Contact">Contact Us</a> |</li>
            <li><a href="#3" target="Help">Help</a> |</li>
            <li><a href="#4" target="Search">Search</a> |</li>
            <li><a href="#5" target="Sitemap">Sitemap</a> |</li>
            <li><a href="#6" target="Other UOB Sites">Other Sites</a> </li>
        </ul>
    </div>
    <div id="footer-copyright">
        Copyright © 2010 Ng Zhong Qin Final Year Project. All Rights Reserved.     
    </div>
</div>
</body></html>