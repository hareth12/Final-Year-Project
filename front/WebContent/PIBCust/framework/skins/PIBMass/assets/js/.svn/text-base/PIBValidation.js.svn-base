function isDecimal(str, msg) {
     var regex = /^\d+(\.\d)?\d*$/;
     if(!(regex.exec(str.value))){
             alert("Please enter valid " + msg + ".");
             str.focus();
               str.select();
     }
}

function isDecimal(elem) {

    var regex = /^\d*(\.\d{1,})?$/;
     if(!(regex.exec(elem.value))){
     	return false;
     }
     return true;
}


function chkEmail(elem){
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if(elem.value.match(emailExp)){
		return true;
	}else{
		return false;
	}
}


function chkDigit(elem) {           
   	var tempString = elem.value;
	tempString = tempString.replace (/\s/g,"");   	
	var pattern = /\D/; 
	var res = (tempString).match(pattern);
	if( res!=null)	  	
	{
		alert("This field requires a numeric entry. Please enter again.");    
      		elem.focus();
      		elem.select();
      		return false;
	}
	else 	   
		return true;
   }


	function isNumeric(elem) {   
		 var regex = /^\d*$/;
     	if(!(regex.exec(elem.value))){
     		return false;
     	}
     	return true;
	}


	 
   function isNumber(inputText) {   
		 var regex =  /[^\d]/i;
		return !(regex.test(inputText));
	}
	
	function isNumberGreaterThanZero(inputText) {   
		 var regex =  /[^\d]/i;
		return !(regex.test(inputText))  && checkGreaterThanZero(inputText);
	}
	
	
	function isNumberWithSpace(inputText) {   
		 var regex =  /[^\d\s]/i;
		return !(regex.test(inputText));
	}
   

   function isEmpty(s){
   		s = trim(s);
		return ((s == null) || (s.length == 0))
	}
function  isAlphaNumeric (inputText){
	var testInput = /[^a-z\d]/i;
	return !(testInput.test(inputText));
}


function  isAlphaNumericWithSpace(inputText){
	var testInput = /[^a-z\d\s]/i;
	return !(testInput.test(inputText));
}

function  isAlphaNumericWithSpecialChar(inputText){
	var testInput = /^(\w|-|!|#|\$|%|&|\'|\*|\+|\?|\/|=|`|@|\.|,|:|;|\)|\(|\\| ){1,}$/;
	return testInput.test(inputText);
}


function  isAlpha (inputText){
	var testInput = /[^a-z\s]/i;
	return !(testInput.test(inputText));
}


function  isName(inputText){
	if(inputText==""){
	return true;
	
	}
	var testInput = /^([a-zA-Z\d]+)([a-zA-Z\s\d]*)$/;
	var testInput2 = /^([a-zA-Z\s\d]*)([a-zA-Z\d]+)$/;	
	var testInput3 = /^([\d\s]*)$/;	
	return (testInput.test(inputText)    &&  testInput2.test(inputText)  &&!testInput3.test(inputText));
}


function  isNameNumeric(inputText){
if(inputText==""){
	return true;
	}
	var testInput = /^([a-zA-Z\d]+)([a-zA-Z\s\d]*)([a-zA-Z\d]+)$/;
	return (testInput.test(inputText));
	}


function addCommas(str){
	var number=str.split(".");
    var s = number[0];
	var decimal = "";
	if (number[1] != null) {
	  decimal = number[1];
	}
	var pattern = /(\d)((\d\d\d)+\b)/
	var r = "";
	while ((s=s.replace(pattern, "$1,$2")) && r != s){
	  r = s;		
	}
	if(r == ""){
		r = "0";
	}
	if (decimal != "" && decimal != "0") {
	  r += "."+decimal;
	}
	else{
		r += ".00";
	}
	return r;
}

function removeCommas(strValue) {
  var commapattern = /,/g;
  return strValue.replace(commapattern, "");
 }
 

function maxDecimalPoint(value, maxAllowed) {
	var position = value.indexOf('.');
	var valueAfterPoint;
	if(position != -1) {
		valueAfterPoint = value.substring(position+1,value.length);
		if(valueAfterPoint.length > maxAllowed) {
			return true;
		}
		else {	
			return false;
		}
	}
	else {
		return false;
	}
}

 	function trimLeft(str) {
      var regex = /^\s+/
      str = str.replace(regex, "");
      return str;
    }

    function trimRight(str) {
      var regex = /\s+$/
      str = str.replace(regex, "");
      return str;
    }

    function trim(str) {
      str = trimLeft(str);
      str = trimRight(str);
      return str;
    }
    
    
    
    
    function validateFloat(astrNumber,astrDigitsBefDec,astrDigitsAfterDec)
{
    var lreComma = new RegExp(",","g");
    var lblnResult = false;
    var lstrVal = astrNumber;
    var lstrDigitsBefDec    = astrDigitsBefDec;
    var lstrDigitsAfterDec  = astrDigitsAfterDec;
    var lblnNegativeAllowed = validateFloat.arguments[3];
    
    if(lstrVal != null && lstrVal.length > 0){
        lstrVal = validateFloat.arguments[0].replace(lreComma,"");
    }else{
        
        return false;
    }

    if(lblnNegativeAllowed == null || lblnNegativeAllowed.length == 0){
        lblnNegativeAllowed = false;
    }

    if(lblnNegativeAllowed){
        
        lexp = "^-?\\d{0," + lstrDigitsBefDec + "}(\\.\\d{0," + lstrDigitsAfterDec + "})?$";
        lreData = new RegExp(lexp);
        lblnResult = lreData.test(lstrVal);
    }else{
        
        lexp = "^\\d{0," + lstrDigitsBefDec + "}(\\.\\d{0," + lstrDigitsAfterDec + "})?$";
        lreData = new RegExp(lexp);
        lblnResult = lreData.test(lstrVal);
    }
    return lblnResult;
}



	function checkGreaterThanZero(numvalue) {
		numvalue = removeCommas(numvalue);
		if (numvalue <= 0.00) {
			return false;
		}
		return true;
	}
function pibJSValidation(obj){
            var returnVal = true;
            var setFcs = false;
            var highlighted = false;
	var classN ="";
            if(obj != '' && obj.length > 0){
                  for(var i = 0; i <obj.length; i++){
                        if(obj[i] != '' && obj[i] != undefined){
                              objElem = MM_findObj(obj[i]);	
				 if(objElem!=null){
				if(objElem.type!=null && objElem.type=="checkbox"  ){
                              var id  =  objElem.id.substring(objElem.id.lastIndexOf('.')+1) +"_td";
							  if(document.getElementById(id)!=null){
						classN =  document.getElementById(id).className; 
                              		highlighted =true;
	                              	if(classN!=null){
							if(classN.indexOf("error-border")==-1){
	                              		  document.getElementById(id).className = classN+" error-border";
							}
	                              	}else{
		                            	  document.getElementById(id).className = "error-border";
	                              	}
					}else{
						if(!highlighted){
							classN = document.getElementById(objElem.id).className;
							if(classN!=null){
								if(classN.indexOf("error-border")==-1){
									document.getElementById(objElem.id).className =  classN+" error-border";                  
                              	}
							}else{
								document.getElementById(objElem.id).className =  "error-border";                  
                              		}
                              	}
}
				}else  if(objElem.type!=null && objElem.type=="radio"  ){
                              		var id  = objElem.id+"_span";
					classN = id.className;
					if(classN!=null){
						if(classN.indexOf("error-border")==-1){
							document.getElementById(id).className =classN+" error-border"; 
						}                     
					}else{
						document.getElementById(id).className="error-border";
					}
                              }
                              else{
				  if(document.getElementById(objElem.id)!=undefined){
					classN = document.getElementById(objElem.id).className;					
						if(classN!=null){
							if(classN.indexOf("form-missinginput")==-1){
								document.getElementById(objElem.id).className =  classN+" form-missinginput";                  
							}
						}else{
							document.getElementById(objElem.id).className =  "form-missinginput";                  
						}
					}                            
                              }                            
				}
                                returnVal = false;
                        }
                  }
                 
                  if(document.getElementById('errorDiv')!=null){
                  	document.getElementById('errorDiv').innerHTML="";
                    document.getElementById('errorDiv').style.display='none';
                  }
            }
            
            if(!returnVal){
                window.scrollTo(0,0);
            	document.getElementById('genricErrorDiv').style.display = 'block';
            }
            
            return returnVal;
}   


function pibJSValidationToDefault(obj){
            var highlighted = false;
            var classN ="";
            if(obj != '' && obj.length > 0){
                  
                  for(var i = 0; i <obj.length; i++){
                        if(obj[i] != '' && obj[i] != undefined){
                              objElem = MM_findObj(obj[i]);	
                              if(objElem!=null){                                                    
							  if(objElem.type!=null && objElem.type=="checkbox"  ){
                              var id  =  objElem.id.substring(objElem.id.lastIndexOf('.')+1) +"_td";
							  if(document.getElementById(id)!=null){
                              		classN =  document.getElementById(id).className; 
                              		highlighted =true;
	                              	if(classN!=null){
	                              		classN =  classN.replace("error-border", "");	                              		
	                              	}else{
		                              	classN="";		                            	
	                              	}
	                              	document.getElementById(id).className = classN;    
                              	}
                              	else
                              	{
                              		if(!highlighted){
                              			classN = document.getElementById(objElem.id).className;
                              			if(classN!=null){
                              				document.getElementById(objElem.id).className = classN.replace("error-border", "");          
                              			}
                              		}
                              	}
							}
	                          else  if(objElem.type!=null && objElem.type=="radio"  ){
                              		var id  = objElem.id+"_span";
                              		classN = document.getElementById(id).className;
                              		if(classN!=null){
                              			document.getElementById(id).className = classN.replace("error-border", "");         

                              		}
                              }
                              else{
                             
                              if(document.getElementById(objElem.id)!=undefined){
                            		  classN = document.getElementById(objElem.id).className;
                              			if(classN!=null){
                              				document.getElementById(objElem.id).className =   classN.replace("form-missinginput", " ");
                              			}else{
	                              			document.getElementById(objElem.id).className="";
                              			}
                              		    
                              }     
                              }                       
                              }                     
                              
                        }
                  }
                  }
} 
            
            
           



	function MM_findObj(n, d) { 
		   	var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		   	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
		  	if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
		  	for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x;
		}
    

	function isDate(dtStr){
		var daysInMonth = DaysArray(12)
		var pos1=dtStr.indexOf(dtCh)
		var pos2=dtStr.indexOf(dtCh,pos1+1)
		var strDay=dtStr.substring(0,pos1)
		var strMonth=dtStr.substring(pos1+1,pos2)
		var strYear=dtStr.substring(pos2+1)
		strYr=strYear
		if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
		if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
		for (var i = 1; i <= 3; i++) {
		 if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
		}
		month=parseInt(strMonth)
		day=parseInt(strDay)
		year=parseInt(strYr)
		if (pos1==-1 || pos2==-1){
		 alert("The date format should be : dd/mm/yyyy")
		 return false
		}
		if (strMonth.length<1 || month<1 || month>12){
		 alert("Please enter a valid month")
		 return false
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		 alert("Please enter a valid day")
		 return false
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		 alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		 return false
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		 alert("Please enter a valid date")
		 return false
		}
		return true
	}


    function  isAlphaNumericPassword (inputText){ 
    	var regex = /^[a-zA-Z0-9\_]{0,}$/;
	    if(!(regex.exec(inputText))){ 
     		return false;
     	} 
     	return true;
    }
	

function formatDate(obj)
{

	dateStr= obj.value;
	curYear= (new Date()).getYear()+"";
	curCentury= parseInt(curYear.substr(0, 2));
	prevCentury=curCentury-1;

	var splitDate;
	validDate=true;
	
	if(dateStr=='')
		return;

	
	if(dateStr.indexOf('/')!=-1 && dateStr.indexOf('-')!=-1)
	{
		validDate=false;
	} else if(dateStr.indexOf('/')!=-1)
	{
		splitDate = dateStr.split("/");
	} else if(dateStr.indexOf('-')!=-1) {
		splitDate = dateStr.split("-");
	} else {
		validDate=false;
	}

	if(validDate && splitDate.length>3 )
		validDate=false;


	if(!validDate)
	{
		alert('Invalid Format');
		obj.value = ""; 
		obj.focus();
		return;
	}

	
	if (splitDate[2] && splitDate[2].length == 2)
	{
		actYear= splitDate[2];
		if(actYear>20)
		{
			splitDate[2] = prevCentury+splitDate[2];
		} else {
			splitDate[2] = curCentury+splitDate[2]
		}

	}


	
	refDate = new Date(splitDate[1]+"/"+splitDate[0]+"/"+splitDate[2]);


	if (splitDate[1] < 1 || splitDate[1] > 12 || refDate.getDate() != splitDate[0] || splitDate[2].length != 4)
	{
		alert('Invalid date');
		obj.value = ""; 
		obj.focus();
	} else {
		obj.value = padString(splitDate[0])+"/"+padString(splitDate[1])+"/"+splitDate[2];
	}
}


function padString(val)
{
	var outStr;
	if(val.length<2)
		outStr="0"+val;
	else 
		outStr=""+val;

	return outStr;
}

function formatTime(obj,format)
{
	var splitTime;
	timeStr= obj.value;

	var hrMaxVal;
	var minMaxVal=59;
	var secMaxVal=59;

	validTime=true;
	
		if(timeStr=='')
		return;
	
	splitFormat = format.split(":");

	if(timeStr.indexOf(':')!=-1)
	{
		splitTime = timeStr.split(":");
	} else {
		validTime=false;
	}

	if(validTime && splitTime.length != splitFormat.length )
		validTime=false;


	if(!validTime)
	{
		alert('Invalid Format');
		obj.value = ""; 
		obj.focus();
		return;
	}

	if(splitFormat[0]=='HH')
		hrMaxVal=23;
    else 
		hrMaxVal=11;

	
	if(splitFormat.length ==2)
	{
		if (splitTime[0] < 0 || splitTime[0] > hrMaxVal ||  splitTime[1] < 0 || splitTime[1] > minMaxVal)
		{
			alert('Invalid Time');
			obj.value = ""; 
			obj.focus();
		} else {
			obj.value = padString(splitTime[0])+":"+padString(splitTime[1]);
		}

	}
	if(splitFormat.length==3)
	{
		if (splitTime[0] < 0 || splitTime[0] > hrMaxVal ||  splitTime[1] < 0 || splitTime[1] > minMaxVal 
					||  splitTime[2] < 0 || splitTime[2] > secMaxVal)
		{
			alert('Invalid Time');
			obj.value = ""; 
			obj.focus();
		} else {
			obj.value = padString(splitTime[0])+":"+padString(splitTime[1])+":"+padString(splitTime[2]);
		}

	}
}

function keyPressHandler(event){

            if(event.keyCode == 27 || event.keyCode == 13){               

                        return false;

            }

}

function disableCtrlKeyCombination(e)
{

	
	var forbiddenKeys = new Array('a','n','c','x','v','j');
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
function colorErrorComponents(str){
	var obj = str.split(",");
	var setFcs = false;
	if(obj != '' && obj.length > 0){
		for(var i = 0; i <obj.length; i++){           
			if(obj[i] != '' && obj[i] != undefined){
				objElem = MM_findObj(obj[i]);
				 if(objElem!=null){             
				var classN;
				if(objElem.type!=null && objElem.type=="checkbox"  ){
					var id  =  objElem.id.substring(objElem.id.lastIndexOf('.')+1) +"_td";
					if(document.getElementById(id)!=null){
						classN =  document.getElementById(id).className; 
						highlighted =true;
						if(classN!=null){
							if(classN.indexOf("error-border")==-1){
								document.getElementById(id).className = classN+" error-border";
							}
						}else{
							document.getElementById(id).className = "error-border";
						}
					}else{
						if(!highlighted){
							classN = document.getElementById(objElem.id).className;
							if(classN!=null){
								if(classN.indexOf("error-border")==-1){
									document.getElementById(objElem.id).className =  classN+" error-border";                  
								}
							}else{
								document.getElementById(objElem.id).className =  "error-border";                  
							}
						}
					}
				}else  if(objElem.type!=null && objElem.type=="radio"  ){
					var id  = objElem.id+"_span";					
					classN = document.getElementById(id).className;
					if(classN!=null){
						if(classN.indexOf("error-border")==-1){
							document.getElementById(id).className =classN+" error-border"; 
						}                     
					}else{
						document.getElementById(id).className="error-border";
					}
				}
				else{
				  if(document.getElementById(objElem.id)!=undefined){
						classN = document.getElementById(objElem.id).className;
						if(classN!=null){
							if(classN.indexOf("form-missinginput")==-1){
								document.getElementById(objElem.id).className =  classN+" form-missinginput";                  
							}
						}else{
							document.getElementById(objElem.id).className =  "form-missinginput";                  
						}
					}
				}
				}                            
				returnVal = false;
				if(!setFcs){
					if(!objElem.disabled){
						if(!objElem.readOnly){
							document.getElementById(objElem.id).focus();
							setFcs = true;

						}
					}

				}
			}
		}
	}
}      