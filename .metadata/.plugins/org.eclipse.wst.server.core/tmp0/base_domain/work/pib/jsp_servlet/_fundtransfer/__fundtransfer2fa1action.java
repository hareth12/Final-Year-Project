package jsp_servlet._fundtransfer;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __fundtransfer2fa1action extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/fundTransfer/fundTransfer2FA1Action.jsp", 1318763583870L ,"10.3.5.0","Asia/Singapore")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n<title>Pseudo Bank Personal Internal Banking</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<meta name=\"author\" content=\"Tom@Lwis (http://www.lwis.net/free-css-drop-down-menu/)\" />\r\n<meta name=\"keywords\" content=\"css, dropdowns, dropdown menu, drop-down, menu, navigation, nav, horizontal, vertical left-to-right, vertical right-to-left, horizontal linear, horizontal upwards, cross browser, internet explorer, ie, firefox, safari, opera, browser, lwis\" />\r\n<meta name=\"description\" content=\"Simple vertical left-to-right direction css drop-down menu demo using clean, standards-friendly, free, easy, cross browser framework for css drop-down menus\" />\r\n<link href=\"/pib/asset/secured/helper.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n\r\n<style type=\"text/css\">\r\n\r\n/* Layout */\r\n@import \"/pib/asset/secured/dropdown.css\";\r\n@import \"/pib/asset/secured/dropdown.vertical.css\";\r\n\r\n/* Theme */\r\n@import \"/pib/asset/secured/default.css\";\r\n\r\n</style>\r\n\r\n\r\n</head>\r\n<body>\r\n<div id=\"wrap\">  <!-- This wrap div needs to encompass everything except the footer div at bottom -->\r\n<h1>Welcome to Pseudo Bank Personal Internal Banking</h1>\r\n\r\n<ul id=\"nav\" class=\"dropdown dropdown-vertical\">\r\n    <li><a href=\"/pib/Landing2FA\">Home</a></li>\r\n    <li class=\"dir\">Account Information\r\n        <ul>\r\n            <li><a href=\"/pib/AccountEnquiry2FA\">Account Summary</a></li>\r\n            <li><a href=\"/pib/ViewOnlineActivity\">Online Activity History</a></li>\r\n            <li class=\"dir\"><a href=\"./\">Manage My Accounts</a>\r\n                <ul>\r\n                    <li><a href=\"./\">Account Summary View</a></li>\r\n                    <li><a href=\"./\">Account Alias</a></li>\r\n                    <li><a href=\"./\">Link Accounts</a></li>\r\n                    <li><a href=\"./\">Delink Accounts</a></li>\r\n                    <li><a href=\"./\">Cheuque Status Enquiry</a></li>\r\n                </ul>\r\n            </li>\r\n        </ul>\r\n    </li>\r\n    <li class=\"dir\">Funds Transfer\r\n        <ul>\r\n            <li><a href=\"/pib/AddPayee2FA1\">Add Payee</a></li>\r\n            <li><a href=\"./\">Manage Payees</a></li>\r\n            <li><a href=\"/pib/FundTransfer2FA1\">Make Transfer</a></li>\r\n        </ul>\r\n    </li>\r\n     <li class=\"dir\">Fixed Deposit\r\n        <ul>\r\n            <li><a href=\"/pib/FDEnquiry1\">Enquiry</a></li>\r\n            <li><a href=\"/pib/FDTransfer1\">Transfer Fund</a></li>\r\n            <li><a href=\"/pib/FDMakePlacement1\">Make Placement</a></li>\r\n        </ul>\r\n    </li>    \r\n    <li class=\"dir\">View Rates\r\n        <ul>\r\n            <li><a href=\"./\">View Unit Trust Prices</a></li>  \r\n            <li><a href=\"./\">View Foreign Exchange Rates</a></li>\r\n            <li><a href=\"./\">View Gold & Silver Rates</a></li>\r\n        </ul>\r\n    </li>\r\n    <li class=\"dir\">Customer Service</a>\r\n        <ul>\r\n            <li><a href=\"/pib/ChangePassword2FA\">Change Password</a></li>\r\n        </ul>\r\n    </li>\r\n    <li><a href=\"/pib/Logout\">Logout</a></li>\r\n</ul>\r\n\t<div id=\"main\">\r\n\t\r\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\tString[][] payee = (String[][])request.getAttribute(\"payee\"); \r\n    \t\t\t\tString from  = (String) request.getAttribute(\"fromAccount\");   \t\r\n    \t\t\t\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\t<form id=\"form1\" name=\"form1\" method=\"post\" action=\"/pib/FundTransfer2FA1Action2\"\">\r\n\t<form action=\"\">\r\n\t<p>\r\n\t\t\t<label>From</label>\r\n\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\t<br></br>\r\n\t\t\t<label>To  </label>\r\n\t   \t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t<br></br>\r\n\t      <label>Amount\r\n\t        <input type=\"text\" name=\"amount\" id=\"amount\" />\r\n\t      </label>\r\n\t      <br></br>\r\n\t\t\t<label>\r\n\t        <input type=\"submit\" name=\"select\" id=\"select\" value=\"Confirm\" />\r\n\t      </label>\r\n\t\t</p>\t\r\n\t\t\t</form>\r\n\t  </form> \r\n\t\r\n\t\r\n\t\r\n\t\r\n\t</div>\r\n\r\n</div>\r\n\r\n<div class=\"footer\">\r\n\t<div id=\"foot\"> <!-- this extra div is just centering the fixed width area of the footer content -->\r\n\r\n    <p>Copyright &copy; 2011 Pseudo Bank. All rights reserved.</p>\r\n    </div>\r\n</div>\r\n\r\n</body>\r\n\r\n\r\n</html>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter bw = (weblogic.servlet.jsp.ByteWriter)out;
        bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            bw.write(_wl_block0Bytes, _wl_block0);
	String[][] payee = (String[][])request.getAttribute("payee"); 
    				String from  = (String) request.getAttribute("fromAccount");   	
    				
            bw.write(_wl_block2Bytes, _wl_block2);
int i =0;
	out.println(" <select name=\"fromAccount\">");
	out.println("<option value=\""+from+"\">"+ "Uniplus"+" "+from+"</option>");
	out.println("</select>");
	
            bw.write(_wl_block3Bytes, _wl_block3);
i =0;
	out.println(" <select name=\"toAccount\">");
	if(payee[0][0]!="null"){	
		while(payee[i][0]!=null){
			out.println("<option value=\""+payee[i][2]+"\">"+ payee[i][0]+" "+payee[i][1]+"</option>");
			i++;
		}
	}
	out.println("</select>");
	
            bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
