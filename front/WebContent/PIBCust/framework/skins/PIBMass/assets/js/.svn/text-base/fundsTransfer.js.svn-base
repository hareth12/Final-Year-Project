var smsOtpLength;
var localcurStr;
    var accountsMap = {}; 
    var genericError = "", accountsString ="";
  	var ajaxURL = "/PIBCust/appmanager/Cust/2FA/com/uob/pib/pageflow/fundstfr/fundstfr/acountChanging.do";

var hrsub=0;
var disableVal = 0;
function chkHideNext(){
	var i = parseInt(document.getElementById("FundTransferController_1.addRow").value);
	for(var a=0;a<=i;a++){
		if(document.getElementById('FundTransferController_1.portletInstance_7.isSameCurrency_'+a).value=="true"){
  			document.getElementById('FundTransferController_1.portletInstance_7.recurringRadio'+a).disabled = false;
	  		document.getElementById('FundTransferController_1.portletInstance_7.futureRadio'+a).disabled = false;  		
			MM_showHideLayers('currency_like_'+a,'','show');
			MM_showHideLayers('currency_unlike_'+a,'','hide');
		} else{
	  		document.getElementById('FundTransferController_1.portletInstance_7.recurringRadio'+a).disabled = true;
  			document.getElementById('FundTransferController_1.portletInstance_7.futureRadio'+a).disabled = true;  		
			MM_showHideLayers('currency_like_'+a,'','hide');
			MM_showHideLayers('currency_unlike_'+a,'','show');
		}
	}
} 

function chkHideNextNew(portletName, val,a,revGiro){
	var hiddenFTType = hiddenFTType_[a];
		if('L' == val){
			document.getElementById(portletName+'recurringRadio'+a).disabled = false;
		  	document.getElementById(portletName+'futureRadio'+a).disabled = false;  		
		  	document.getElementById('currency_like_'+a).style.display = "block";
		  	document.getElementById('currency_unlike_'+a).style.display = "none";
		  	if('Immediate' == hiddenFTType || '' == hiddenFTType){
		  		if('' == hiddenFTType){
			  		hiddenFTType_[a] = "Immediate";
			  	}
			  	document.getElementById('transferTypeSpanFut'+a).style.display = "none";
				document.getElementById('transferTypeSpanRec'+a).style.display = "none";		  	
		  	} else if('FutureDated' == hiddenFTType){
			  	document.getElementById('transferTypeSpanFut'+a).style.display = "block";
				document.getElementById('transferTypeSpanRec'+a).style.display = "none";		  	
		  	} else if('Recurring' == hiddenFTType){
			  	document.getElementById('transferTypeSpanFut'+a).style.display = "none";
				document.getElementById('transferTypeSpanRec'+a).style.display = "block";		  	
				populateFreq(a);
		  	}
		}
		else {
			document.getElementById(portletName+'recurringRadio'+a).disabled = true;
  			document.getElementById(portletName+'futureRadio'+a).disabled = true;  		
  			document.getElementById('currency_like_'+a).style.display = "none";
		  	document.getElementById('currency_unlike_'+a).style.display = "block";
		  	document.getElementById('transferTypeSpanFut'+a).style.display = "none";
			document.getElementById('transferTypeSpanRec'+a).style.display = "none";
			document.getElementById(portletName+'immidieteRadio'+a).checked =true ;
			
		}
		if('yes' == revGiro ){
			document.getElementById(portletName+'recurringRadio'+a).disabled = true;
  			document.getElementById(portletName+'futureRadio'+a).disabled = true;  		
		  	document.getElementById('currency_like_'+a).style.display = "block";
		  	document.getElementById('currency_unlike_'+a).style.display = "none";
		  	document.getElementById('transferTypeSpanFut'+a).style.display = "none";
			document.getElementById('transferTypeSpanRec'+a).style.display = "none";
			document.getElementById(portletName+'immidieteRadio'+a).checked =true ;
		}
} 

function currency_onchange(row_no){	
	var url = "com/uob/pib/pageflow/fundstfr/fundstfr/processCurrencyOnChange.do";
	var FromAccount = document.getElementById("FromAccount"+row_no).value;
	var ToAccount = document.getElementById("ToAccount"+row_no).value;
	var LikeAmount = document.getElementById("FundTransferController_1.LikeAmount"+row_no).value;	
	var UnLikeAmount = document.getElementById("FundTransferController_1.UnLikeAmount"+row_no).value;
	var prevToCurrCode = document.getElementById("FundTransferController_1.UnLikeCurrencyName"+row_no).value;
	var methName = 'doTransaction()';
	var param = { ToAccount : ToAccount, LikeAmount :  LikeAmount , UnLikeAmount : UnLikeAmount , FromAccount : FromAccount , methName : methName , row_no : row_no};
	invokeAjax(url,param);
  }
  
  function rtrim(stringToTrim) {
	return stringToTrim.replace(/\s+$/,"");
  }

function doRenderTolerance(){
	var temp = new Array();
	temp = responseValue.split(';');
	meth = temp[0];
	toleranceRate = temp[1];
	row_noDB = temp[2];
	var number = new Number(row_noDB);
 	var row_no =number.toString();
   	document.getElementById("FundTransferController_1.toleranceValue_"+row_no).innerText = toleranceRate;
   	document.getElementById('apDiv1').style.visibility = 'hidden'; 
  }  
   
function toggleTxnType(portletName){
	 document.getElementById('TFRTFR45.Recurring').click();
}

function MM_showHideLayers() { //v9.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length); i+=1) 
  with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
    return false;
} 

function disableDrpDwnOnChng(selIndex,type){
	MM_findObj(portletName+'listindex').value=selIndex;
	if(type=='1'){
		MM_findObj(portletName+'onChangeId').value=type;
	} else if(type=='2'){
		MM_findObj(portletName+'onChangeId').value=type;
	} else if(type=='3'){
		MM_findObj(portletName+'onChangeId').value=type;
	}
	return true;
}  


	function clearHighlightedFields(){	
		
		

		for(var index=0;index<=parseInt(addRow);index++){	
			var clearArray = new Array(4);	
			clearArray[0] = portletName+"FromAccount"+index;
			clearArray[1] = portletName+"ToAccount"+index;
			clearArray[2] = portletName+"LikeAmount"+index;
			clearArray[3] = portletName+"UnLikeAmount"+index;
			pibJSValidationToDefault(clearArray);
		}
	document.getElementById('genricErrorDiv').innerHTML ="";
			document.getElementById('genricErrorDiv').style.display='none';
			if(document.getElementById('errorDiv')!=null){
			document.getElementById('errorDiv').innerHTML ="";
			document.getElementById('errorDiv').style.display='none';
			}

	}



function callAjax(elem,event,index){
	clearHighlightedFields();
	window.focus();
	var onChangeId  =document.getElementById(portletName+'onChangeId').value;
	if(onChangeId=='1'){
		if(document.getElementById(portletName+'FromAccount'+index).value==""){
			document.getElementById(portletName+'ToAccount'+index).disabled=true;
		}
		else{
			document.getElementById(portletName+'ToAccount'+index).disabled=false;
		}
		document.getElementById(portletName+'ToAccount'+index).value=""
		document.getElementById(portletName+'LikeAmount'+index).value ="";
		document.getElementById(portletName+'UnLikeAmount'+index).value ="";
		
	}
	if(onChangeId=='2'){
		if(isSameCurrency_[index] == 'true'){
			document.getElementById(portletName+'UnLikeAmount'+index).value = document.getElementById(portletName+'LikeAmount'+index).value;
		}
		else{
			document.getElementById(portletName+'LikeAmount'+index).value = document.getElementById(portletName+'UnLikeAmount'+index).value;
		}
	}
	var fromAccountCode  =document.getElementById(portletName+'FromAccount' +index).value
	var toAccountCode = document.getElementById(portletName+'ToAccount'+index).value
	var likeAmount = document.getElementById(portletName+'LikeAmount'+index).value;
	var unlikeAmount = document.getElementById(portletName+'UnLikeAmount'+index).value;


var params = index +"@ "+
			onChangeId + "@ " +	
			fromAccountCode + "@ " +
			toAccountCode + "@ " +
			likeAmount + "@ " +
			unlikeAmount  ;


		ajax_getData(elem,'',ajaxURL,event, params);


		

		
}
	function disableLinks11(val){
		if(hrsub == 0 || hrsub == '0'){
			hrsub = 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	function disableLinkOnLoad(obj){
		if(disableVal == 0){
			disableVal = 1;
			var href = obj.getAttribute("href");
		    if(href && href != "" && href != null){
		       obj.setAttribute('href_bak', href);
		    }
		    obj.removeAttribute('href');
			return true;
		}
		else {
			return false;
		}
	}
	
   function validateOnSubmitFundsTransfer(){
   	document.getElementById('genricErrorDiv').innerHTML = genericError;
   	document.getElementById('ajaxErrorDiv').style.display = "none";
   
 	rowNo = addRow;
	var errArray = new Array(20);
	var i = 0;
      	var clearArray = new Array(20);
	var clVal = 0;
        var alAdded = false;
 	for(j=0;j<=parseInt(rowNo);j++){
	    fromAccnt = MM_findObj(portletName+'FromAccount'+j);
    
	    toAccnt = MM_findObj(portletName+'ToAccount'+j);
		transferLikeAmt = MM_findObj(portletName+'LikeAmount'+j);
		transferUnLikeAmt = MM_findObj(portletName+'UnLikeAmount'+j);
		isSameCurrency = isSameCurrency_[j];
		divaaa = displayCurrDiv_[j];
		trnsferTypeImm = MM_findObj(portletName+'immidieteRadio'+j);
		trnsferTypeRec = MM_findObj(portletName+'recurringRadio'+j);
		trnsferTypeFut = MM_findObj(portletName+'futureRadio'+j);
		futureDate = MM_findObj(portletName+'futureDate'+j);
		startDate = MM_findObj(portletName+'startDate'+j);
		comboFreq = MM_findObj(portletName+'comboFreq_'+j);
		comboNoOfTransfers = MM_findObj(portletName+'comboNoOfTransfers_'+j);						
		
	    if(isEmpty(fromAccnt.value)){
    		errArray[i] = portletName+"FromAccount"+j;
	        i = i + 1;
	        alAdded = true;
	     }
	     else {
	        clearArray[clVal] = portletName+"FromAccount"+j;
			clVal = clVal + 1;
	     }
	    if(isEmpty(toAccnt.value)){
    		errArray[i] = portletName+"ToAccount"+j;
	        i = i + 1;
	        alAdded = true;
	     }
	     else {
	         clearArray[clVal] = portletName+"ToAccount"+j;
			clVal = clVal + 1;
	     }	     
	    if(isSameCurrency == "true"){
    	    if(isEmpty(transferLikeAmt.value)){
	    		errArray[i] = portletName+"LikeAmount"+j;
		        i = i + 1;
		        alAdded = true;
		        
		     }
		     else if(!isDecimal(transferLikeAmt)){
		     	errArray[i] = portletName+"LikeAmount"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else if(!checkGreaterThanZero(transferLikeAmt.value)){
		     	errArray[i] = portletName+"LikeAmount"+j;
		        i = i + 1;
		        alAdded = true;		     
		     }
		     else {
		       clearArray[clVal] = portletName+"LikeAmount"+j;
			    clVal = clVal + 1;
		     }
	    } else {
    	    if(isEmpty(transferUnLikeAmt.value)){
	    		errArray[i] = portletName+"UnLikeAmount"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else if(!isDecimal(transferUnLikeAmt)){
	    		errArray[i] = portletName+"UnLikeAmount"+j;
		        i = i + 1;
		        alAdded = true;		     
		     } else if(!checkGreaterThanZero(transferUnLikeAmt.value)){
	    		errArray[i] = portletName+"UnLikeAmount"+j;
		        i = i + 1;
		        alAdded = true;			     
		     }
		     else {
		         clearArray[clVal] = portletName+"UnLikeAmount"+j;
			    clVal = clVal + 1;
		     }	
	    }
     
     	if(trnsferTypeFut.checked){
	     	 if(isEmpty(futureDate.value)){
	    		errArray[i] = portletName+"futureDate"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else {
		         clearArray[clVal] = portletName+"futureDate"+j;
			    clVal = clVal + 1;
		     }
     	} else if(trnsferTypeRec.checked){
	     	 if(isEmpty(startDate.value)){
	    		errArray[i] = portletName+"startDate"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else {
		       clearArray[clVal] = portletName+"startDate"+j
			    clVal = clVal + 1;
		     }
	     	 if(comboFreq.value=='Please select...'){
	    		errArray[i] = portletName+"comboFreq_"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else {
		        clearArray[clVal] = portletName+"comboFreq_"+j;
			    clVal = clVal + 1;
		     }		     	
	     	 if(comboNoOfTransfers.value=='Please select...' || comboNoOfTransfers.value==''){
	    		errArray[i] = portletName+"comboNoOfTransfers_"+j;
		        i = i + 1;
		        alAdded = true;
		     }
		     else {
		          clearArray[clVal] = portletName+"comboNoOfTransfers_"+j;
			    clVal = clVal + 1;
		     }	
     	}
     
	}
	if(!alAdded){
    	errArray = new Array(0);
    }
    pibJSValidationToDefault(clearArray);
    var retVal = pibJSValidation(errArray);
    return retVal;
  } 
  
  function validateToleranceOnSubmitFT(rowNo){
	var errArray = new Array(20);
	var i = 0;
     	var clearArray = new Array(20);
	var clVal = 0;
    var alAdded = false;
 	for(j=0;j<=parseInt(rowNo);j++){
	    toleranceRate = MM_findObj(portletName+'toleranceRate'+j);
	    if(isEmpty(toleranceRate.value)){
    		errArray[i] = portletName+"toleranceRate"+j;
	        i = i + 1;
	        alAdded = true;
	     } else if(!isDecimal(toleranceRate)){
	    	errArray[i] = portletName+"toleranceRate"+j;
		    i = i + 1;
		    alAdded = true;		     
	     } else {
	         clearArray[clVal] = portletName+"toleranceRate"+j;
		    clVal = clVal + 1;
	     }
    }
  
  	if(!alAdded){
    	errArray = new Array(0);
    }
	pibJSValidationToDefault(clearArray);
    var retVal = pibJSValidation(errArray);
    return retVal;
  }

	
 function refreshWindowAddPayeeFT(bankCode,branchCode,localBank,challenge,pubKey){
   var bankcode = MM_findObj(portletName+'payeeBankCode');
   bankcode.value = bankCode;
   var branchcode = MM_findObj(portletName+'payeeBranchCode');
   branchcode.value = branchCode;
   document.getElementById('challenge').value=challenge;
   document.getElementById('publicKey').value=pubKey;
   document.getElementById(portletName+'overLayBtn').onclick();
  }
  
 function closeWindowAddPayeeFT(){
   document.getElementById(portletName+'overLayBtn').onclick();	
  }  
  
 function validateOnSubmitAddPayeeFT(){
 	bankcode = MM_findObj(portletName+'payeeBankCode');
    bankName = MM_findObj(portletName+'payeeBankName');
    branchName = MM_findObj(portletName+'payeeBranchName');
    payeeAccountNo = MM_findObj(portletName+'payeeAccountNo');
    payeeName = MM_findObj(portletName+'payeeName');
    currencySelected = MM_findObj(portletName+'CurrencyList');
    
	var errArray = new Array(5);
	var i = 0;
   	var clearArray = new Array(5);
	var clVal = 0;
    var alAdded = false;
    if(isEmpty(bankName.value)){
    	errArray[i] = portletName+"payeeBankName";
        i = i + 1;
        alAdded = true;
     }
     else {
         clearArray[clVal] = portletName+"payeeBankName";
	     clVal = clVal + 1;
     }
     
     if(bankcode.value == '7375'){
   	 } else{
	    if(isEmpty(branchName.value)){
	    	errArray[i] = portletName+"payeeBranchName";
	        i = i + 1;
	        alAdded = true;
	     }
	     else {
	        clearArray[clVal] = portletName+"payeeBranchName";
		     clVal = clVal + 1;
	     }
   	 }
     
     if(isEmpty(payeeAccountNo.value)){
    	errArray[i] = portletName+"payeeAccountNo";
        i = i + 1;
        alAdded = true;
     } else if(!isNumeric(payeeAccountNo)){
    	errArray[i] = portletName+"payeeAccountNo";
        i = i + 1;
        alAdded = true;     
   	} else {
        clearArray[clVal] = portletName+"payeeAccountNo";
	     clVal = clVal + 1;
     }
     
     if(currencySelected.value=='Please select...'){
    	errArray[i] = portletName+"CurrencyList";
        i = i + 1;
        alAdded = true;
     }
     else {
        clearArray[clVal] = portletName+"CurrencyList";
	     clVal = clVal + 1;
     }
     
     if(isEmpty(payeeName.value)){
    	errArray[i] = portletName+"payeeName";
        i = i + 1;
        alAdded = true;
     }  
     else {
       clearArray[clVal] = portletName+"payeeName";
	    clVal = clVal + 1;
     }     
     
     if(!alAdded){
     	errArray = new Array(0);
     }
     pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
   	return retVal;
  } 
  
  
   function validateOnSubmitAddPayeeSMSAuth(){
    smsPassword = MM_findObj(portletName+'smsPassword');
 	var errArray = new Array(1);
	var i = 0;
        var clearArray = new Array(1);
	var clVal = 0;
    var alAdded = false;
     
     if(isEmpty(smsPassword.value)){
    	errArray[i] = portletName+"smsPassword";
        i = i + 1;
        alAdded = true;
     } else if(!isNumeric(smsPassword)){
    	errArray[i] = portletName+"smsPassword";
        i = i + 1;
        alAdded = true;     
   	} else {
         clearArray[clVal] = portletName+"smsPassword";
	   clVal = clVal + 1;
     }
     
     if(!alAdded){
     	errArray = new Array(0);
     }
     pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
   	return retVal;
  } 
  
   function validateOnSubmitAddPayeeTokAuth(){
 
    tokenPassword = MM_findObj(portletName+'tokenPassword');
    
	var errArray = new Array(1);
	var i = 0;
     	var clearArray = new Array(1);
	var clVal = 0;
    var alAdded = false;
     
     if(isEmpty(tokenPassword.value)){
    	errArray[i] = portletName+"tokenPassword";
        i = i + 1;
        alAdded = true;
     } else if(!isNumeric(tokenPassword)){
    	errArray[i] = portletName+"tokenPassword";
        i = i + 1;
        alAdded = true;     
   	} else {
        clearArray[clVal] = portletName+"tokenPassword";
	    clVal = clVal + 1;
     }
     
     if(!alAdded){
     	errArray = new Array(0);
     }
     pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
   	return retVal;
  } 
  
   function validateOnSubmitUpdtSMSAuth(){
 
    smsPassword = MM_findObj(portletName+'smsPassword');
    
	var errArray = new Array(1);
	var i = 0;
   	var clearArray = new Array(1);
	var clVal = 0;
    var alAdded = false;
     
     if(isEmpty(smsPassword.value)){
    	errArray[i] = portletName+"smsPassword";
        i = i + 1;
        alAdded = true;
     } else if(!isNumeric(smsPassword)){
    	errArray[i] = portletName+"smsPassword";
        i = i + 1;
        alAdded = true;     
   	} else {
        clearArray[clVal] = portletName+"smsPassword";
	    clVal = clVal + 1;
     }
     
     if(!alAdded){
     	errArray = new Array(0);
     }
      pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
   	return retVal;
  } 
  
   function validateOnSubmitUpdtTokenAuth(){
    tokenPassword = MM_findObj(portletName+'tokenPassword');
	var errArray = new Array(1);
	var i = 0;
     	var clearArray = new Array(1);
	var clVal = 0;
    var alAdded = false;
     
     if(isEmpty(tokenPassword.value)){
    	errArray[i] = portletName+"tokenPassword";
        i = i + 1;
        alAdded = true;
     } else if(!isNumeric(tokenPassword)){
    	errArray[i] = portletName+"tokenPassword";
        i = i + 1;
        alAdded = true;     
   	} else {
        clearArray[clVal] = portletName+"tokenPassword";
	    clVal = clVal + 1;
     }
     
     if(!alAdded){
     	errArray = new Array(0);
     }
      pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
    	return retVal;
  } 
  
 function validateOnSubmitUpdtPayeeFT(){
 
    payeeNameUpdate = MM_findObj(portletName+'payeeNameUpdate');
    
	var errArray = new Array(2);
	var i = 0;
	var clearArray = new Array(2);
	var clVal = 0;
    var alAdded = false;
     
     if(isEmpty(payeeNameUpdate.value)){
    	errArray[i] = portletName+"payeeNameUpdate";
        i = i + 1;
        alAdded = true;
     } else {
         clearArray[clVal] = portletName+"payeeNameUpdate";
	    clVal = clVal + 1;
     }
     
     if(!alAdded){
     	errArray = new Array(0);
     }
      pibJSValidationToDefault(clearArray);
     var retVal = pibJSValidation(errArray);
   	return retVal;
  }   
  
  function getBranchFTFullBank(){
  	document.getElementById("hiddenBranchCode").value='';
    document.getElementById("actionPerformed").value="getBranchDetils";
    document.getElementById("overLayBtn").onclick();	
    return true;
  }
	  
	  
	function getBranchIDFTFullBank(i){
	   var ele = document.getElementById("hiddenBranchCode");
	   ele.value = i;
	} 

	function closeWindowFTFullBank(){
	  	var bankCode = document.getElementById("hiddenBankCode").value;
	  	var branchCode = document.getElementById("hiddenBranchCode").value;
		
		var errArray = new Array(5);
		var i = 0;
                var clearArray = new Array(5);
	        var clVal = 0;
	    var alAdded = false;
	    var branchCode = document.getElementById("hiddenBranchCode").value;
	
	    if(bankCode=='7375'){
	
	    } else {
	        if(branchCode==""){
		    	errArray[i] = "hiddenBranchCode";
		        i = i + 1;
		        alAdded = true;        	
		     }
	    }
	    
	    if(!alAdded){
	    	errArray = new Array(0);
	    }
            pibJSValidationToDefault(clearArray);
	    var retVal = pibJSValidation(errArray);
		if(retVal==false){
			return false;
		} else {
		  	var challenge=document.getElementById('challenge').value;
			var pubKey=document.getElementById('publicKey').value; 
			
		  	window.parent.refreshWindowAddPayeeFT(bankCode,branchCode,"",challenge,pubKey);
		}
	 
		  	var challenge=document.getElementById('challenge').value;
			var pubKey=document.getElementById('publicKey').value; 
			
		  	window.parent.refreshWindowAddPayeeFT(bankCode,branchCode,"",challenge,pubKey);
	 
	}
	function cancelWindowFTFullBank(){
	  	window.parent.closeWindowAddPayeeFT();
	}
	
	 function validateOnSubmitUpdtDelFTTrans(listSize){
	
		var errArray = new Array(20);
		var i = 0;
                var clearArray = new Array(20);
	        var clVal = 0;
	    var alAdded = false;
	    var p = 0;
	    var chknme = MM_findObj('TFRTFR15wlw-checkbox_group_key:{actionForm.fundsTransferVO.selectedFutTransactions}');
	    
	 	for(j=0;j<listSize;j++){
	    
		    transferDate = MM_findObj(portletName+'transferDate'+j);
			transAmtDisplay = MM_findObj(portletName+'transAmtDisplay'+j);
			initials = MM_findObj(portletName+'initials'+j);
			
			chkbx = document.getElementById(portletName +'checkBoxIndex'+j).checked;
	
			if(chkbx==true){
				p = p + 1;
			} 		
		
			if(parseInt(selRecSelectedCount)==0){
				if(j==listSize-1){
					if(p>0){						
					} else {
						for(q=0;q<listSize;q++){
						     errArray[i] = portletName+"checkBoxIndex"+q;
				       		 i = i + 1;
				      		 alAdded = true;
						}			
					}
				}
			}
	   		if(transferDate!=null){
		   		 if(isEmpty(transferDate.value)){
		    		errArray[i] = portletName+"transferDate"+j;
			        i = i + 1;
			        alAdded = true;
			     }
			     else {
			        clearArray[clVal] = portletName+"transferDate"+j;
	                clVal = clVal + 1;
			     }
	   		}
	   		
	   		if(transAmtDisplay!=null){
			    if(isEmpty(transAmtDisplay.value)){
		    		errArray[i] = portletName+"transAmtDisplay"+j;
			        i = i + 1;
			        alAdded = true;
			     }
			     else {
			              clearArray[clVal] = portletName+"transAmtDisplay"+j;
	                clVal = clVal + 1;
			     }	   			
	   		}
	   
		}
		
		if(!alAdded){
	    	errArray = new Array(0);
	    }
	     pibJSValidationToDefault(clearArray);
	    var retVal = pibJSValidation(errArray);
	    return retVal;
  } 
  
  
     function getFundsTransferType(indexVal){	
   		if(document.getElementById(portletName+'futureRadio'+indexVal).checked){
			hiddenFTType_[indexVal] =  "FutureDated";
			document.getElementById('transferTypeSpanFut'+indexVal).style.display = "block";
			document.getElementById('transferTypeSpanRec'+indexVal).style.display = "none";
		}
		else if(document.getElementById(portletName+'recurringRadio'+indexVal).checked){
			hiddenFTType_[indexVal] =  "Recurring";
			document.getElementById('transferTypeSpanFut'+indexVal).style.display = "none";
			document.getElementById('transferTypeSpanRec'+indexVal).style.display = "block";
		} 
		else 
		{
			hiddenFTType_[indexVal] =  "Immediate";
			document.getElementById('transferTypeSpanFut'+indexVal).style.display = "none";
			document.getElementById('transferTypeSpanRec'+indexVal).style.display = "none";
		}
	}

	function populateFreq(index){
		var selFreq = document.getElementById(portletName+"comboFreq_"+index).value;
		var selTrans = document.getElementById(portletName+"comboNoOfTransfers_"+index).value;
		
		while ( document.getElementById(portletName+"comboNoOfTransfers_"+index).options.length ) document.getElementById(portletName+"comboNoOfTransfers_"+index).options[0] = null;
		
		if('Daily' == selFreq){
			getFrqList(dailyList,index,selTrans);
			
		} else if('Weekly' == selFreq){
			getFrqList(weeklyList,index,selTrans);
			
		} else if('Monthly' == selFreq){
			getFrqList(monthlyList,index,selTrans);
	
		} else if('Quarterly' == selFreq){
			getFrqList(quaterlyList,index,selTrans);
		
		} else if('Please select...' == selFreq){
			document.getElementById(portletName+"comboNoOfTransfers_"+index).options[0]=new Option('Please select...','Please select...');
		} 
	}	
	
	function getFrqList(list,index,selTrans){
		document.getElementById(portletName+"comboNoOfTransfers_"+index).options[0]=new Option('Please select...','Please select...');
		var p = 1;
		var temp = new Array();
		temp = list.split(',');
		var initial = temp[0];
		var dailyfinal = temp[1];
		var isPresent = 'No';
		
		var optionValue = initial;
		for(var i=initial;i<=parseInt(dailyfinal);i++)
		{
			document.getElementById(portletName+"comboNoOfTransfers_"+index).options[p]=new Option(optionValue,optionValue);
			optionValue++;
			p++;
			if(parseInt(selTrans)==i){
				isPresent = 'Yes';
			}
		}	
		if(isPresent == 'No'){
		} else {
			document.getElementById(portletName+"comboNoOfTransfers_"+index).value = selTrans;
		}
	}	
	function updateIndexNo(val){
		elem = document.getElementById(portletName+"selIndex");
		elem.value=val;
		return true;
	}
function setValuesInCallingModule(arrVar, callMethodName){
	 	var selBank = document.getElementById(portletName+"payeeBankCode").value;
		locBank = arrVar[3];
		if('Y' != locBank){
			if(callMethodName == 'bank'){
				document.getElementById(portletName+"payeeBankCode").value = arrVar[2];
				document.getElementById(portletName+"payeeBankName").value = arrVar[1];
				document.getElementById(portletName+"bankCodeSpanId").innerHTML = arrVar[2];
				document.getElementById(portletName+"payeeBranchName").value='';
				document.getElementById(portletName+"payeeBranchCodeSpan").innerHTML='';
				document.getElementById(portletName+"payeeBranchCode").value='';
				document.getElementById(portletName+"payeeBranchName").disabled=false;
				document.getElementById(portletName+"CurrencyList").value=localcurStr; 
				document.getElementById(portletName+"CurrencyList").disabled=true;
			}
			if(callMethodName == 'branch'){
				document.getElementById(portletName+"payeeBranchCode").value = arrVar[2];
				document.getElementById(portletName+"payeeBranchName").value = arrVar[1];
				document.getElementById(portletName+"payeeBranchCodeSpan").innerHTML = arrVar[2];
			}
		}
		else {
			var elem = document.getElementById(portletName+"localBnkText");
			var lclText;
			if(elem == 'undefined'){
				lclText = 'Branch Code is not required if Payee Bank is UOB';
			}
			else {
				lclText = elem.innerHTML;
			}
			if(lclText == ''){
				lclText = 'Branch Code is not required if Payee Bank is UOB';
			}
			document.getElementById(portletName+"payeeBranchName").value=lclText;
			document.getElementById(portletName+"payeeBranchName").disabled=true;
			document.getElementById(portletName+"CurrencyList").disabled=false;
			document.getElementById(portletName+"payeeBankCode").value = arrVar[2];
			document.getElementById(portletName+"bankCodeSpanId").innerHTML = '';
			document.getElementById(portletName+"payeeBranchCodeSpan").innerHTML='';
		}
		document.getElementById(portletName+"payeeBranchName").setAttribute("param2Value", selBank);
    }
    
  function enableOverlayBtn(){
       var bankRadio = document.getElementById('bankradio');
       if(bankRadio !=null && bankRadio.checked){
         document.getElementById("btnOkOverlay").disabled=false;
         document.getElementById("btnOkOverlay").className='button-alignR btnOk';	
       }else{
         document.getElementById("btnOkOverlay").disabled=true;
         document.getElementById("btnOkOverlay").className='button-alignR btnOk_disabled';	
       }
    }
    
    function clearCodeValue(selectedObj){
      var selectedObjName=selectedObj.name;
      var selectedItem = selectedObjName.substring(selectedObjName.lastIndexOf('.')+1,selectedObjName.lastIndexOf('}'));
	    if(selectedItem!=null && selectedItem=="payeeBankName"){
	    	document.getElementById(portletName+"payeeBankCode").value="";
	    	document.getElementById(portletName+"bankCodeSpanId").innerHTML="";
	    	document.getElementById(portletName+"payeeBranchCodeSpan").innerHTML="";
	    	document.getElementById(portletName+"payeeBranchCode").value="";
	    	document.getElementById(portletName+"payeeBranchName").value="";
	    	document.getElementById(portletName+"payeeBranchName").disabled=true;
	    	document.getElementById(portletName+"currencyList").disabled=false;
	    }
	    if(selectedItem!=null && selectedItem=="payeeBranchName"){
	    	document.getElementById(portletName+"payeeBranchCodeSpan").innerHTML="";
	    	document.getElementById(portletName+"payeeBranchCode").value="";
	    }
	}
    
   function resetBankCode(){
  	   var payeeBankCode = document.getElementById(portletName+"payeeBankCode").value;
	   var urlstring = document.getElementById(portletName+"hiddenBnkCode1").href;
	   var arrf = urlstring.split('&');
	   for(var i=0;i<parseInt(arrf.length);i++) {
	       if (arrf[i].match(payeeBankCode) == null ) {
			         if (arrf[i].match('hiddenBnkCode=') != null ) {
			            document.getElementById(portletName+"hiddenBnkCode1").href = 
				        document.getElementById(portletName+"hiddenBnkCode1").href.replace(arrf[i], "hiddenBnkCode="+payeeBankCode);
			         }
	         }
	     }
	}	
	
	function setAjaxResInCallingModule(elements){
	   var status =	elements[0];
		if('S'==status){
		
			var toAccList = elements[1];
			var equivalentAmount = elements[2];
			var toAccCurrency =	elements[3];
			var exchangeRate = elements[4];
			var toleranceRate=	elements[5];
			var index  =elements[6];
			var disEquiAmount  =elements[11];
				
			hiddenFTType_[index] =elements[8];
			reverseGiro_[index] =elements[9];
			displayCurrDiv_[index]=elements[10];
			isSameCurrency_[index]=elements[11];
			LikeCurrencyName[index]=elements[3];
			toleranceValue[index]=	elements[5];

			

				chkHideNextNew(portletName, elements[10],elements[6],elements[9]);





		
			var onChangeId = document.getElementById(portletName+'onChangeId').value;
			
			if('1'==onChangeId){
			
				document.getElementById(portletName+'ToAccount'+index).length = 0;
				
				
				toAccList=toAccList.replace('[',"");
				toAccList =toAccList.replace(']',"");
				
				var array= 	toAccList.split(',');
				
				var optn = document.createElement("OPTION");
				optn.text =  plsSel;
				optn.value = '';
				document.getElementById(portletName+'ToAccount'+index).options.add(optn);
				for(var i =0;i<array.length ;i++){
				
					var optn = document.createElement("OPTION");
					optn.text =  accountsMap[trim(array[i])] ;
					optn.value = trim(array[i]);
					document.getElementById(portletName+'ToAccount'+index).options.add(optn);
				}
				
				
				
				document.getElementById(portletName+'ToAccount'+index).value='';
				document.getElementById('currency_unlike_'+index).style.display ="none";
				document.getElementById('currency_like_'+index).style.display ="block";
			
			}
			
			
			
			if('false'==disEquiAmount){
				document.getElementById(portletName+'UnLikeCurrency_Name_'+index).innerHTML =toAccCurrency;
				document.getElementById(portletName+'ExchangeRate_'+index).innerHTML =exchangeRate;
				document.getElementById(portletName+'toleranceValue_'+index).innerHTML =toleranceRate;
				document.getElementById('EquivalentAmount_'+index).innerHTML =equivalentAmount;
				document.getElementById('currency_unlike_'+index).style.display ="block";
				document.getElementById('currency_like_'+index).style.display ="none";

			}
			else{
				document.getElementById(portletName+'LikeCurrency_Name_'+index).innerHTML =toAccCurrency;
				document.getElementById('currency_unlike_'+index).style.display ="none";
				document.getElementById('currency_like_'+index).style.display ="block";

			}
			document.getElementById('ajaxErrorDiv').style.display = "none";

			
			var i=0;
				
			var clearArray = new Array(1);
			clearArray[i] = portletName+"LikeAmount"+index;
			i=i+1;
			clearArray[i] = portletName+"UnLikeAmount"+index;
			pibJSValidationToDefault(clearArray);
		
		}
	
		if('E'==status){
		
		
		
			var index = elements[3];
			

			document.getElementById('ajaxErrorCode').innerHTML =elements[1];
			document.getElementById('ajaxErrorDesc').innerHTML = elements[2];
			
			var onChangeId = document.getElementById(portletName+'onChangeId').value;
		
			
			if(elements[4]!=null&&trim(elements[4])!=''){
			
				var i=0;
				   var errArray = new Array(1);
				 	errArray[i] = portletName+"elements[4]"+index;
				
				document.getElementById(portletName+elements[4]+index).className =  "form-missinginput"; 
				if(onChangeId==2){
				document.getElementById(portletName+'ToAccount'+index).value='';
				}
				
				
			}else{
			
			
				document.getElementById(portletName+'ToAccount'+index).value='';
				document.getElementById(portletName+'ToAccount'+index).disabled=true;
				document.getElementById(portletName+'FromAccount'+index).value='';
				document.getElementById(portletName+'UnLikeAmount'+index).value='';
				document.getElementById(portletName+'LikeAmount'+index).value='';
				
				document.getElementById(portletName+'LikeCurrency_Name_'+index).innerHTML = localCurrency;
				document.getElementById('currency_unlike_'+index).style.display ="none";
				document.getElementById('currency_like_'+index).style.display ="block";
				chkHideNextNew(portletName, 'L',index,'');
			}
			
			document.getElementById('ajaxErrorDiv').style.display = "block";
		
		}

 
	
	}

		

function	toggleToAccount(portletName,index){
if(document.getElementById(portletName+'FromAccount'+index).value==""){

document.getElementById(portletName+'ToAccount'+index).disabled=true;
}
else{
document.getElementById(portletName+'ToAccount'+index).disabled=false;
}



}