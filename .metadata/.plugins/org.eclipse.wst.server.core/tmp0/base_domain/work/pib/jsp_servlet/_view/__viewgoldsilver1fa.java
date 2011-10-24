package jsp_servlet._view;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __viewgoldsilver1fa extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/View/viewGoldSilver1FA.jsp", 1319450472129L ,"10.3.5.0","Asia/Singapore")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n<title>Pseudo Bank Personal Internal Banking</title>\r\n<link href=\"/pib/asset/secured/helper.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\r\n <link rel=\"icon\" type=\"image/ico\" href=\"/pib/asset/favicon.ico\" />\r\n<style type=\"text/css\">\r\n\r\n/* Layout */\r\n@import \"/pib/asset/secured/dropdown.css\";\r\n@import \"/pib/asset/secured/dropdown.vertical.css\";\r\n\r\n/* Theme */\r\n@import \"/pib/asset/secured/default.css\";\r\n\r\n</style>\r\n\r\n</head>\r\n<body>\r\n<div id=\"wrap\">  <!-- This wrap div needs to encompass everything except the footer div at bottom -->\r\n<h1>Welcome to Pseudo Bank Personal Internet Banking</h1>\r\n\r\n<ul id=\"nav\" class=\"dropdown dropdown-vertical\">\r\n    <li><a href=\"/pib/Landing1FA\">Home</a></li>\r\n    <li class=\"dir\">Account Information\r\n        <ul>\r\n            <li><a href=\"/pib/AccountEnquiry1FA\">Account Summary</a></li>\r\n            <li class=\"dir\"><a href=\"./\">Manage My Accounts</a>\r\n                <ul>\r\n                    <li><a href=\"./\">Account Summary View</a></li>\r\n                </ul>\r\n            </li>\r\n        </ul>\r\n    </li>\r\n    <li class=\"dir\">View Rates\r\n        <ul>\r\n            <li><a href=\"/pib/ViewUnitTrust1FA\">View Unit Trust Prices</a></li>\r\n            <li><a href=\"/pib/ViewForex1FA\">View Foreign Exchange Rates</a></li>\r\n            <li><a href=\"/pib/ViewGoldSilver1FA\">View Gold & Silver Rates</a></li>\r\n        </ul>\r\n    </li>\r\n    <li class=\"dir\">Customer Service\r\n        <ul>\r\n            <li><a href=\"/pib/ChangePassword1FA\">Change Password</a></li> \r\n        </ul>\r\n    </li>\r\n    <li><a href=\"/pib/Logout\">Logout</a></li>\r\n</ul>\r\n<div id=\"main\">\r\n\r\n<table style=\"text-align: center; width: 80%;\" border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\r\n\t\t<tbody>\r\n\t\t<tr>\r\n\t\t  <td>Description</td><td>Unit</td><td>Bank Sells</td><td>Bank Buys</td> \r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>GOLD CERTIFICATE - 1 KILOCERT </td><td>SGD/KG</td><td>67626.0</td><td>67426.0</td> \r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t  <td>GOLD SAVINGS A/C - 1 GM\t</td><td> SGD/GM</td><td> 67.63</td><td>67.43 </td> \r\n\t\t</tr>\t\r\n\t\t<tr>\r\n\t\t  <td>SILVER GRANULES - 1 KILO </td><td> SGD/KG</td><td>1405.98 </td><td>0.0</td> \r\n\t\t</tr>\t\r\n\t\t<tr>\r\n\t\t  <td>SILVER PASSBOOK ACCOUNT - 1 OZ</td><td>SGD/OZ</td><td>40.77</td><td>40.1</td> \r\n\t\t</tr>\t\r\n\t\t  </tbody>\r\n\t\t</table>\r\n\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n\r\n\t<div class=\"footer\">\r\n\t\t<div id=\"foot\"> <!-- this extra div is just centering the fixed width area of the footer content -->\r\n\t        <p>Copyright &copy; 2011 Pseudo Bank. All rights reserved.</p>\r\n\t    </div>\r\n\t</div>\r\n\r\n\r\n\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
