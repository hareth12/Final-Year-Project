var g_PopupIFrame;
function xstooltip_show_ie6(tooltipId, parentId, posX, posY)
{
	var divPopup=document.getElementById(tooltipId);
	divPopup.style.zIndex=divPopup.style.zIndex+1;
	var iFrame = document.createElement("IFRAME");
	iFrame.setAttribute("src", "/PIBCust/framework/skins/PIBMass/assets/images/common/spacer.gif");
	iFrame.style.position="absolute";
	if ((divPopup.style.top == '' || divPopup.style.top == 0) && (divPopup.style.left == '' || divPopup.style.left == 0))
	{
		divPopup.style.width = 230 + 'px';
		divPopup.style.height = divPopup.offsetHeight + 'px';
	}
	img = document.getElementById(parentId); 
	if (posX + divPopup.offsetWidth > img.offsetWidth)
		posX = img.offsetWidth - divPopup.offsetWidth;
	if (posX < 0 ) posX = 0; 
	x = xstooltip_findPosX(img) + posX;
	y = xstooltip_findPosY(img) + posY;
	divPopup.style.left = x + 'px';
	divPopup.style.top = y + 'px';
	iFrame.style.left = x + 'px';
	iFrame.style.top = y + 'px';
	iFrame.style.width =230 + 'px';
	iFrame.style.height =divPopup.offsetHeight + 'px';
	document.body.appendChild(iFrame);
	g_PopupIFrame=iFrame;
	divPopup.style.visibility ="visible";
}

function xstooltip_hide_ie6(id)
{
	var divPopup;
	divPopup=document.getElementById(id);
	divPopup.style.visibility = "hidden";
	document.body.removeChild(g_PopupIFrame);
	g_PopupIFrame=null;
}

function xstooltip_show(tooltipId, parentId, posX, posY)
{
		if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)){var ieversion=new Number(RegExp.$1); if (ieversion>=8); else if (ieversion>=7); else if (ieversion>=6){xstooltip_show_ie6(tooltipId, parentId, posX, posY); return;}}

    it = document.getElementById(tooltipId);
    if ((it.style.top == '' || it.style.top == 0) 
        && (it.style.left == '' || it.style.left == 0))
    {
        
        it.style.width = it.offsetWidth + 'px';
        it.style.height = it.offsetHeight + 'px';
        }
        img = document.getElementById(parentId); 
    
      
        if (posX + it.offsetWidth > img.offsetWidth) posX = img.offsetWidth - it.offsetWidth;
        if (posX < 0 ) posX = 0; 
        
        x = xstooltip_findPosX(img) + posX;
        y = xstooltip_findPosY(img) + posY;

        it.style.top = y + 'px';
        it.style.left = x + 'px';

    it.style.visibility = 'visible'; 
}

function xstooltip_findPosX(obj) 
{
  var curleft = 0;
  if (obj.offsetParent) 
  {
    while (obj.offsetParent) 
        {
            curleft += obj.offsetLeft
            obj = obj.offsetParent;
        }
    }
    else if (obj.x)
        curleft += obj.x;
    return curleft;
}

function xstooltip_findPosY(obj) 
{
    var curtop = 0;
    if (obj.offsetParent) 
    {
        while (obj.offsetParent) 
        {
            curtop += obj.offsetTop
            obj = obj.offsetParent;
        }
    }
    else if (obj.y)
        curtop += obj.y;
    return curtop;
}

function xstooltip_hide(id)
{
		if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)){var ieversion=new Number(RegExp.$1);if (ieversion>=8); else if (ieversion>=7); else if (ieversion>=6){xstooltip_hide_ie6(id);return;}}

    it = document.getElementById(id); 
    it.style.visibility = 'hidden'; 
}