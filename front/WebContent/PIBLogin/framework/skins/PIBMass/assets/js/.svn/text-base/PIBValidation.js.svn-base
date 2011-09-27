
   function isEmpty(s){
            s = trim(s);
            return ((s == null) || (s.length == 0))

      }
function  isAlphaNumeric (inputText){
      var testInput = /[^a-z\d]/i;
      return !(testInput.test(inputText));

}

function  isAlphaNumericPassword (inputText){

      var regex = /^[a-zA-Z0-9\_]{0,}$/;

      if(!(regex.exec(inputText))){
            return false;
     }
     return true;
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
function  isAlpha (inputText){

      var testInput = /[^a-z\s]/i;

      return !(testInput.test(inputText));

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

  

      function MM_findObj(n, d) { 

                  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {

                  d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}

                  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];

                  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x;

            }

function colorErrorComponents(str){
	var obj = str.split(",");
	var setFcs = false;
	if(obj != '' && obj.length > 0){
		for(var i = 0; i <obj.length; i++){           
			if(obj[i] != '' && obj[i] != undefined){
				objElem = MM_findObj(obj[i]);
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
var smsOtpLength;
function smsFormValidation(){
		var errArray = new Array(1);
		var i = 0;
		elem1 = document.getElementById("smsOTPData");	
		
		if(isEmpty(elem1.value)||((elem1.value.length < smsOtpLength)||(elem1.value.length > smsOtpLength))){
				errArray[i] ="smsOTPData";
				i = i +1;
			}
		if(i < 1){
				errArray = new Array(0);
			}
			var retVal = pibJSValidation(errArray);
			return retVal;
		
}

var tokenOtpLength;
function tokenFormValidation(){
		var errArray = new Array(1);
		var i = 0;
		elem1 = document.getElementById("tokendatafield");
		
		
		if(isEmpty(elem1.value)||((elem1.value.length < tokenOtpLength)||(elem1.value.length > tokenOtpLength))){
				errArray[i] ="tokendatafield";
				i = i +1;
			}
		
		
		
		if(i < 1){
				errArray = new Array(0);
			}
			var retVal = pibJSValidation(errArray);
			return retVal;
		
}

 
