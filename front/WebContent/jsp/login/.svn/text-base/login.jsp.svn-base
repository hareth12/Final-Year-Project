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






<a name="Top"></a>
<div id="bgtop" class="wrapper">
    <div id="header">
        <div id="header-left">
            
                
                
                    
            
        </div>
        
        
        
        <div style="clear:both;"></div>
        
    </div>
    














  




<div id="logincontent">
<form name="logon1" id="logon1" action="/front/PIBLogin/appmanager/Login/Public?_nfpb=true&amp;_windowLabel=SECSEC01&amp;SECSEC01_actionOverride=%2Fcom%2Fuob%2Fpib%2Fpageflow%2Flogon%2FprocessLogin&amp;_pageLabel=SECSEC01" method="post">
<table id="table-main" class="width-980" style="align:center;">
    <tr> 
    <td class="width-110"></td>
        
        <td class="width-760">  
            
                    
        </td>
    </tr>
    
</table>
<div style="clear:both;"></div>
<style>.vert-align-top {vertical-align:top;}</style>
<table id="table-main6" class="width-980 vert-align-top" align="center" border="0">
    <tr> 
        <td class="width-110" rowspan="7"></td>
        <td class="formText row-whitebg vert-align-top">
            
        </td>

        <td class="width-110" rowspan="7"></td>
    </tr>
    
       
    <tr>
        <td class="vert-align-top">
            <table>
                <tr>
                    <td class="formTextBold width-130 row-main"><div>Username</div></td>
                    <td class="formField width-455 row-main">
                        <div>
                            <input type="text" name="SECSEC01{actionForm.userName}" id="userName" class="form-short" maxlength="16" size="26" disabled autocomplete="off" style="text-transform:uppercase" onkeypress="if(event.keyCode==13) { return false; }; return disableCtrlKeyCombination(event);" onkeydown="return disableCtrlKeyCombination(event);" onblur="javascript:userNameToUpper()">


                        </div>
                    </td>   
                </tr>
                <tr>
                    <TD class="formTextBold width-130 row-alt">                                 
                        <div>Password<br>
                            <span class="formText">(Case Sensitive)</span>
                        <div>
                    </td>
                    <td class="formField width-455 row-alt">
                        <div><input type="password" name="SECSEC01{actionForm.password}" id="PASSWORD1" class="form-short" maxlength="24" size="26" disabled autocomplete="off" onkeypress="if(event.keyCode==13) { return false; }; return disableCtrlKeyCombination(event);" onkeydown="return disableCtrlKeyCombination(event);">


                        </div>
                    </td>   
                  </tr>
                   <tr>
                     <td class="row-main"  colspan="2"><div>
                        </div>
                        
                        
                    
                        
                        
                    </td>
                  </tr>
                  <tr> 
                    <td  colspan="2">
                            <div class="button-alignL">
                                 <div>
                            <input type="button" name="SECSEC01actionOverride:processClear" id="loginIdxClearBtn" class="button-alignL btnClear" value=" " onclick="return doClearNSubmit()">


                                                    </div>
                                 
                            </div>
                            <div>
                                <div>
                <input type="button" name="SECSEC01actionOverride:processLogin" id="loginIdxSubmitBtn" class="button-alignR btnSubmit" value=" " onclick=" return AppletEncription()">


                                </div>
                            </div>
                            <div style="clear:left;"></div>
                        </td>
                      
                    </tr>
                   <tr> 
                    <td  colspan="2"></td>
                  </tr>
                </table>
                </td>
                      
                    </tr>
                    </table>    

</div>
    </form>


    <form name="logon" id="logon" action="/front/PIBLogin/appmanager/Login/Public?_nfpb=true&amp;_windowLabel=SECSEC01&amp;SECSEC01_actionOverride=%2Fcom%2Fuob%2Fpib%2Fpageflow%2Flogon%2FprocessLogin&amp;_pageLabel=SECSEC01" method="post">
        


        


        


        


        
        <div id="hiddenDiv" align="left" style="visibility:hidden;">
            <input type="button" id="hiddenButton" value=" " onclick="e2esubmit(false,'https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/Public/pib.c?__c=7d1&amp;token=null');return false;">
<script language="JavaScript" type="text/JavaScript">
<!--
-->
</script>

            <input type="button" id="hiddenButton" value=" " onclick="e2esubmit(false,'https://pib.uob.com.sg:443/PIBLogin/appmanager/Login/Public/pib.c?__c=7d2&amp;token=null');return false;">
<script language="JavaScript" type="text/JavaScript">
<!--
-->
</script>

        </div>
        </form>

    
        
    
    
    





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