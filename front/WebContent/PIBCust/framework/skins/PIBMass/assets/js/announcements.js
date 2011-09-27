var iframeids=[]
var iframehide="yes"

	var getFFVersion=navigator.userAgent.substring(navigator.userAgent.indexOf("Firefox")).split("/")[1]
	var FFextraHeight=parseFloat(getFFVersion)>=0.1? 16 : 0 
	var FFextraWidth=parseFloat(getFFVersion)>=0.1? 16 : 0 

	function resizeCaller() {
		var dyniframe=new Array()
		for (i=0; i<iframeids.length; i++){
			if (document.getElementById){
				resizeIframe(iframeids[i])
			}
			
			if ((document.all || document.getElementById) && iframehide=="no"){
				var tempobj=document.all? document.all[iframeids[i]] : document.getElementById(iframeids[i])
				tempobj.style.display="block"
			}
		}
	}

	function resizeIframe(frameid){
	$(document).ready(function(){
		var currentfr=document.getElementById(frameid)
		if (currentfr && !window.opera){
			currentfr.style.display="block"
			currentfr.width = 740;
			
			if (currentfr.Document && currentfr.Document.body.scrollHeight){			
				if(currentfr.Document.body.innerHTML==''){
					currentfr.height = 0;
				}else{
					currentfr.height = currentfr.Document.body.scrollHeight;
				}

			}else if (currentfr.contentDocument){			
				if(currentfr.contentDocument.body.innerHTML==''){
					currentfr.height=0;
				}else{
				currentfr.height = currentfr.contentDocument.body.offsetHeight+FFextraHeight; 
			}

			}
			if (currentfr.addEventListener){
				currentfr.addEventListener("load", readjustIframe, false)
			}
			else if (currentfr.attachEvent){
				currentfr.detachEvent("onload", readjustIframe) 
				currentfr.attachEvent("onload", readjustIframe)
			}
		}
		})
	}

function readjustIframe(loadevt) {
	var crossevt=(window.event)? event : loadevt
	var iframeroot=(crossevt.currentTarget)? crossevt.currentTarget : crossevt.srcElement
	if (iframeroot)
	resizeIframe(iframeroot.id);
}

if (window.addEventListener)
	window.addEventListener("load", resizeCaller, false)
else if (window.attachEvent)
	window.attachEvent("onload", resizeCaller)
else
	window.onload=resizeCaller


		

	function MM_findObj(n, d) { 
			var p,i,x;  
			if(!d) 
				d=document; 
			if((p=n.indexOf("?"))>0&&parent.frames.length) {
				d=parent.frames[n.substring(p+1)].document; 
				n=n.substring(0,p);
			}
			if(!(x=d[n])&&d.all){
				x=d.all[n]; 
			}
			for (i=0; !x&&i < d.forms.length; i++) {
				x=d.forms[i][n];
			}
			for(i=0; !x&&d.layers&&i < d.layers.length; i++) {
				x=MM_findObj(n,d.layers[i].document); 
			}
			return x;
		}


		function loadme(){
		}

		function onLoadAlert(message){
			
		}
		window.status="Page Loading";
		function raiseEventClose(elem){
			elem.parentNode.fireEvent("onmouseout");
		
		}

      
		window.status="Done";