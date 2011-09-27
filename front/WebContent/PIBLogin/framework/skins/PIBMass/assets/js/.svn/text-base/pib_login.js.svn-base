var AppletOK=false;
	var stat=0;
	var ONCE=false;
	var _sbmDn = false;
 var RN_String;
	var  pubKeyValue ;
	var Mod_siz = 1024; 
	var Pub_String;
	var Mod_String;
   	var idMinLength ;
	var idMaxLength ;
	var pwdMinLength ;
   	var pwdMaxLegth ;
   	var clearAction ;
   	var uobApplet = new UOBApplet();   
   	var isCKSAppletEnabled;
	function disableCtrlKeyCombination(e)
        {
        var forbiddenKeys = new Array('a','n','c','v','x','j');
        var key;
        var isCtrl;
        if(window.event)
	        {
	                key = window.event.keyCode;     
	                if(window.event.ctrlKey)
	                        isCtrl = true;
	                else
	                        isCtrl = false;
	        }
	        else
	        {
	                key = e.which;     
	                if(e.ctrlKey)
	                        isCtrl = true;
	                else
	                        isCtrl = false;
	        }
        if(isCtrl)
        {
                for(i=0; i<forbiddenKeys.length; i++)
                {
                        
                        if(forbiddenKeys[i].toLowerCase() == String.fromCharCode(key).toLowerCase())
                        {

                                return false;
                        }
                }
        }
     return true;
	}
	function clickIE4(){
                  if (event.button==2){
                  return false;
                  }
    }
    function clickNS4(e){
                  if (document.layers||document.getElementById&&!document.all){
                                 if (e.which==2||e.which==3){
                                           return false;
                                 }
                         }
    }
    if (document.layers){
                  document.captureEvents(Event.MOUSEDOWN);
                  document.onmousedown=clickNS4;
    }

    else if (document.all&&!document.getElementById){
                  document.onmousedown=clickIE4;
    }
    document.oncontextmenu=new Function("return false;")
	function init() {
		if (!document.getElementById) 
		return false;
		var f = document.getElementById('logon');
		f.setAttribute("autocomplete", "off");
	} 
  	function dostoreRSApublickey()
		{
			var errorNum = uobApplet.OBM_SpecifyRSAPublicKey( parseInt (Mod_siz)/8 , Pub_String, Mod_String);			
			if(errorNum != 0){		
			    return false;
			}
			return true;
	  }
     function doEncryptUserLoginMsg()
      {
      	  uobApplet = new UOBApplet();
		  dostoreRSApublickey();
		  
		  var C_String = "";    
		  var P_String = "";    
		  var PINString = document.logon1.PASSWORD1.value;		
	     	
		  var errorNum = uobApplet.OBM_EncryptPassword(PINString, RN_String);
		
		  if (errorNum != 0)
		  {
		    return false;
		  }
		  else
		  {
		  	C_String = uobApplet.OBM_GetEncryptedPassword();
		    P_String = uobApplet.OBM_GetEncodingParameter();
			if (C_String != "")
		    {
	    		document.logon.NEWPASSWORD.value = C_String.toUpperCase();
	    		document.logon.ENCODINGPARAM.value = P_String.toUpperCase();
		    }
		    else
		    {
		      return false;
		    }
		  }
		  return true;
		}
	function doClearNSubmit(){
		if(isCKSAppletEnabled){
			var appletobj=document.applets['TrustFieldExtApp'];
			
			if (!AppletOK ||appletobj==null ) {
				bSuccess = false;
				alert(strErrMessage);
				return false;			
			}
		}
		if(isFirstReq){
			isFirstReq=false;
			document.logon1.userName.value = "";
			document.getElementById("userName").className ="form-short";
			document.logon1.PASSWORD1.value = "";
			document.getElementById("PASSWORD1").className ="form-short";
			document.getElementById('genricErrorDiv').style.display = 'none';
			document.logon.action =  clearAction;
			document.logon.submit();
			return false;
		}else{
			return false;
		}
	}		  
  function userNameToUpper() {
  document.logon1.userName.value = document.logon1.userName.value.toUpperCase();
	}
	
  function formValidation(){
 		if(_sbmDn == true){
 			return false;
 		}
   		var userName =document.logon1.userName.value;
   		userName = userName.replace(/^\s+|\s+$/g, '') ;
		var errArray = new Array(2);
		var i = 0;
		var j=0;
		elem1 = document.getElementById("userName");
		elem2 = document.getElementById("PASSWORD1");
		var clearArray = new Array(2);
		var isPassWordValidated = true;
		var isUserNameValidated = true;
		if(isEmpty(elem1.value)){
				isUserNameValidated  = false;
			 }
		if((elem1.value.length < idMinLength)||(elem1.value.length > idMaxLength))  {
				isUserNameValidated  = false;
			 }
		if(!isAlphaNumericPassword(elem1.value)){
				isUserNameValidated  = false;
			 }
		if(isEmpty(elem2.value)){
				isPassWordValidated  = false;
			 }
		if((elem2.value.length < pwdMinLength)||(elem2.value.length > pwdMaxLegth))  {
				isPassWordValidated  = false;
			 }
 		if(!isAlphaNumericPassword(elem2.value)){
				isPassWordValidated  = false;
			}
			if(isUserNameValidated&&isPassWordValidated){
				clearArray[j] ="userName";
				j = j +1;
				clearArray[j] ="PASSWORD1";
				j = j +1;
			}else{
				errArray[i] ="userName";
				i = i +1;
				errArray[i] ="PASSWORD1";
				i = i +1;
			}
		if(i < 1){
				errArray = new Array(0);
			}
			pibJSValidationToDefault(clearArray);		
			var retVal = pibJSValidation(errArray);
			if(retVal){
				_sbmDn = true;
			}
			return retVal;
 }
function loginFormSubmit()
{
	document.getElementById('loginIdxSubmitBtn').click();
}
function initApplet() {
	if(isCKSAppletEnabled){
	   try{
	    var appletobj=document.applets['TrustFieldExtApp'];
	    if(appletobj){
		    appletobj.start();	    
		       
			    AppletOK = true;
			    document.getElementById("PASSWORD1").disabled =false;
			    document.getElementById("userName").disabled =false;		   
				document.getElementById("userName").focus();
	    	
	    }else{
			alert(strErrMessage);
		}
	    }catch(err){
	    	alert(strErrMessage);
	    }
    }else{
    	document.getElementById("PASSWORD1").disabled =false;
		document.getElementById("userName").disabled =false;		   
		document.getElementById("userName").focus();
    }
}

function AppletEncription() {
	bSuccess = true;
	if(isCKSAppletEnabled){
		var appletobj=document.applets['TrustFieldExtApp'];
		 
		try{
		if (!AppletOK ||appletobj==null ) {
			bSuccess = false;
			alert(strErrMessage);
			return false;
			
		}
		}catch(err){	
			alert(strErrMessage);
			bSuccess = false;
			return false;
		}
	}
    var isValidData=formValidation();
   	
	if (isValidData) {
     	bSuccess = true;
	} else{
		document.getElementById("userName").value = "";
       document.getElementById("PASSWORD1").value = "";
		bSuccess = false;
		return false;
	}	
	if (bSuccess && bCheckOnce(false)) {
		var EPIN1="";
		if(isCKSAppletEnabled){
			document.TrustFieldExtApp.load_PublicKey(pubKeyValue);
			document.TrustFieldExtApp.addPIN(document.logon1.PASSWORD1.value);
			document.TrustFieldExtApp.auth();
			EPIN1 = document.TrustFieldExtApp.getEPIN();
		}
		document.logon.PASSWORD.value = EPIN1;
  	    doEncryptUserLoginMsg();  	    
	  	    document.logon1.PASSWORD1.value=document.logon1.PASSWORD1.value.replace(/./g,' ');
			document.logon.UserId.value  =		document.logon1.userName.value;
			SetOnce();
			document.logon.submit();
			return false;
		
	}
}
function bCheckOnce(Set) {
	var ret;
	if (ONCE) {
		ret = false;
	}  
	else {
		ret = true;    
     }
	if (Set) {
		ONCE = true;
	}
	return ret;
}
function SetOnce() {
	ONCE = true;
	return;
}