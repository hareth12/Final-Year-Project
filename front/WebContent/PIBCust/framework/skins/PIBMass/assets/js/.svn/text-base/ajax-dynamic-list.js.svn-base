/*Ajax dynamic list Copyright (C) 2006  DTHMLGoodies.com, Alf Magne Kalleland This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA Dhtmlgoodies.com., hereby disclaims all copyright interest in this script
written by Alf Magne Kalleland. Alf Magne Kalleland, April 2006 Owner of DHTMLgoodies.com*/
var posX=0;var posY=0;var m1='';var ind=0;var listMSIE=false;var actItem;
var ajlstObjects=new Array();
var ajlstCacheList=new Array();
var actInp=false,optDivFstItem=false;
var currLetters=new Array();
var ajOptDiv=false,optDivifr=false;
if(navigator.userAgent.indexOf('MSIE')>=0 && navigator.userAgent.indexOf('Opera')<0)listMSIE=true;
var iever=false;
if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)){	
	var iever=new Number(RegExp.$1); 
	if (iever>=8); 
	else if (iever>=7); 
	else if (iever>=6){
	iever=true;
	}
}
function ajGetTopPos(inVal){
	var retVal=inVal.offsetTop;
	  while((inVal=inVal.offsetParent) != null){
	  retVal += inVal.offsetTop;
	}
	return retVal;
}
function ajCancelEvent(){return false;}
function ajGetLeftPos(inVal){
	var retVal=inVal.offsetLeft;
	while((inVal = inVal.offsetParent) != null)retVal += inVal.offsetLeft;
	return retVal;
}
function ajOptSetVal(e,inVal){
	if(!inVal)inVal=this;
	var tmpVal=inVal.innerHTML;
	if(listMSIE)tmpVal=inVal.innerText;else tmpVal = inVal.textContent;
	if(!tmpVal)tmpVal=inVal.innerHTML;
	actInp.value=tmpVal;
	var arr1 = inVal.id.split('VALSEPERATOR1');
	var arr2 = arr1[1].split('FLDSEPERATOR3');
	actInp.value=arr2[1];
	setValuesInCallingModule(arr2, m1);
	ajOptHide();
}
function ajOptHide(){
	if(ajOptDiv)ajOptDiv.style.display='none';
	if(optDivifr)optDivifr.style.display='none';
}
function rollOverActItem(item,fromKeyBoard){
	if(actItem)actItem.className='optionDiv';
	item.className='selectOpt';
	actItem = item;
	if(fromKeyBoard){
		if(actItem.offsetTop>ajOptDiv.offsetHeight){
			ajOptDiv.scrollTop=actItem.offsetTop - ajOptDiv.offsetHeight + actItem.offsetHeight + 2 ;
		}
		if(actItem.offsetTop<ajOptDiv.scrollTop){
			ajOptDiv.scrollTop=0;
		}
	}
}
function buildList(letters,param0){
	ajOptDiv.innerHTML='';
	actItem=false;
	optDivFstItem=false;
	var optAdd=false;
	for(var no=0;no<ajlstCacheList[param0][letters.toLowerCase()].length;no++){
		if(ajlstCacheList[param0][letters.toLowerCase()][no].length==0)continue;
		optAdd=true;
		var div=document.createElement('DIV');
		var items=ajlstCacheList[param0][letters.toLowerCase()][no].split(/FLDSEPERATOR1/gi);
		if(ajlstCacheList[param0][letters.toLowerCase()].length==1 && actInp.value == items[0]){
			ajOptHide();
			return;
		}
		div.innerHTML=items[items.length-1];
		div.id=items[0];
		div.className='optionDiv';
		div.onmouseover=function(){rollOverActItem(this,false) }
		div.onclick=ajOptSetVal;
		if(!optDivFstItem)optDivFstItem=div;
		ajOptDiv.appendChild(div);
	}
	if(optAdd){
		ajOptDiv.style.display='block';
		if(optDivifr)optDivifr.style.display='';
		rollOverActItem(optDivFstItem,true);
	}
}
	function showContent(ajInd,inVal,param0,whichIndex){
		if(whichIndex!=ind)return;
		var letters=inVal.value;
		var content=ajlstObjects[ajInd].response;
		var elements=content.split('|');
		var elements1 = new Array();
		for(var i = 0; i < (elements.length)-1; i++){
			elements1[i] = elements[i];
		}
		ajlstCacheList[param0][letters.toLowerCase()]=elements1;
		buildList(letters,param0);
	}
	function ajOptResize(inVal){
		ajOptDiv.style.top=(ajGetTopPos(inVal)+inVal.offsetHeight+posY)+'px';
		ajOptDiv.style.left=(ajGetLeftPos(inVal)+posX)+'px';
		if(optDivifr){
			optDivifr.style.left=ajOptDiv.style.left;
			optDivifr.style.top=ajOptDiv.style.top;
		}
	}
	function ajax_showOptions(inVal,param0, varURL, e, minChar, param2){
		if(e.keyCode==13 || e.keyCode==9)return;
		if(currLetters[inVal.name]==inVal.value)return;
		if(!ajlstCacheList[param0])ajlstCacheList[param0] = new Array();
		currLetters[inVal.name]=inVal.value;
		if(!ajOptDiv){
			ajOptDiv=document.createElement('DIV');
			if(iever){
				ajOptDiv.id='ajax_listOfOptions_ie6';
			}else{			
			ajOptDiv.id='ajax_listOfOptions';
			}

			document.body.appendChild(ajOptDiv);
			if(listMSIE){
				optDivifr=document.createElement('IFRAME');
				optDivifr.setAttribute("src", "/PIBCust/framework/skins/PIBMass/assets/images/common/spacer.gif");
				optDivifr.border='0';
				optDivifr.style.width = ajOptDiv.clientWidth + 'px';
				optDivifr.style.height = ajOptDiv.clientHeight + 'px';
				optDivifr.id = 'ajax_listOfOptions_iframe';
				document.body.appendChild(optDivifr);
			}
			var allInputs = document.getElementsByTagName('INPUT');
			for(var no=0;no<allInputs.length;no++){
				if(!allInputs[no].onkeyup)allInputs[no].onfocus = ajOptHide;
			}
			var allSelects = document.getElementsByTagName('SELECT');
			for(var no=0;no<allSelects.length;no++){
				allSelects[no].onfocus = ajOptHide;
			}
			var oldonkeydown=document.body.onkeydown;
			if(typeof oldonkeydown!='function'){
				document.body.onkeydown=optkeyNav;
			}else{
				document.body.onkeydown=function(){oldonkeydown();optkeyNav() ;}
			}
			var oldonresize=document.body.onresize;
			if(typeof oldonresize!='function'){
				document.body.onresize=function() {ajOptResize(inVal); };
			}else{
				document.body.onresize=function(){oldonresize();
				ajOptResize(inVal) ;}
			}
		}
		if(inVal.value.length < minChar){
	       if(inVal.value== null || trim(inVal.value).length==0){
	       	if(typeof window.clearCodeValue == 'function'){clearCodeValue(inVal);}
	       	}
		ajOptHide();
		return;
		}
		
		ajOptDiv.style.top=(ajGetTopPos(inVal)+inVal.offsetHeight+posY)+'px';
		ajOptDiv.style.left=(ajGetLeftPos(inVal)+posX)+'px';
		if(optDivifr){
			optDivifr.style.left=ajOptDiv.style.left;
			optDivifr.style.top=ajOptDiv.style.top;
		}
		actInp=inVal;
		ajOptDiv.onselectstart=ajCancelEvent;
		ind++;
			var tmpInd=ind/1;
			ajOptDiv.innerHTML='';
			var ajInd=ajlstObjects.length;
			ajlstObjects[ajInd]=new sack();
			m1=param0;
			var url=varURL+'?'+'source='+param0+'&param1='+encodeURIComponent(inVal.value);
			if(param2 != '' && param2 != null){
				var param2Val=document.getElementById(param2).value;
				url=url+'&param2='+encodeURIComponent(param2Val);
			}
			ajlstObjects[ajInd].requestFile=url;
			ajlstObjects[ajInd].onCompletion=function(){
			showContent(ajInd,inVal,param0,tmpInd); };
			ajlstObjects[ajInd].runAJAX();
	}
	function optkeyNav(e){
		if(document.all)e=event;
		if(!ajOptDiv)return;
		if(ajOptDiv.style.display=='none')return;
		if(e.keyCode==38){
			if(!actItem)return;
			if(actItem && !actItem.previousSibling)return;
			rollOverActItem(actItem.previousSibling,true);
		}
		if(e.keyCode==40){
			if(!actItem){
				rollOverActItem(optDivFstItem,true);
			}else{
				if(!actItem.nextSibling)return;
				rollOverActItem(actItem.nextSibling,true);
			}
		}
		if(e.keyCode==13 || e.keyCode==9){
			if(actItem && actItem.className=='selectOpt'){
				ajOptSetVal(false,actItem);
			}
			if(e.keyCode==13)return false; else return true;
		}
		if(e.keyCode==27){ajOptHide();}
	}
	document.documentElement.onclick=autoHideList;
	function autoHideList(e){
		if(document.all)e = event;
		if (e.target) source=e.target;
			else if (e.srcElement) source=e.srcElement;
			if (source.nodeType==3) //Safari bug
				source=source.parentNode;
		if(source.tagName.toLowerCase()!='input' && source.tagName.toLowerCase()!='textarea')ajOptHide();
	}
	function ajax_list_cancelEvent(){return false;}
	
	
	
	
	
	
	
	
	
	function ajax_getData(inVal,param0, varURL, e, param2){
		if(e.keyCode==13 || e.keyCode==9)return;
		if(!ajlstCacheList[param0])ajlstCacheList[param0] = new Array();
		currLetters[inVal.name]=inVal.value;
			var tmpInd=ind/1;
			ajOptDiv.innerHTML='';
			var ajInd=ajlstObjects.length;
			ajlstObjects[ajInd]=new sack();
			m1=param0;
			var url=varURL+'?'+'source='+param0+'&param1='+encodeURIComponent(inVal.value);
			if(param2 != '' && param2 != null){
				url=url+'&param2='+encodeURIComponent(param2);
			}
			
			ajlstObjects[ajInd].requestFile=url;
			ajlstObjects[ajInd].onCompletion=function(){
			getResponse(ajInd,inVal,param0,tmpInd); };
			ajlstObjects[ajInd].runAJAX();
	}
	
	
	function getResponse(ajInd,inVal,param0,whichIndex){
		if(whichIndex!=ind)return;
		var letters=inVal.value;
		var content=ajlstObjects[ajInd].response;

		var elements=content.split('|');


		
			setAjaxResInCallingModule(elements);
	
	}
	
	
	
	
	
	
	
	
	
	