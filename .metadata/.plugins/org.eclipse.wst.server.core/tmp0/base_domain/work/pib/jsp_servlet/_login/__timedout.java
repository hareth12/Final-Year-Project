package jsp_servlet._login;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __timedout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/Login/timedout.jsp", 1317406928978L ,"10.3.5.0","Asia/Singapore")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n        <title>Pseudo Bank Login</title>\r\n         \r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"/pib/asset/login/home.css\"/>\r\n</head>\r\n    <body class=\"small login\">\r\n        <div id=\"wrapper\">\r\n    <div id=\"header\"><h1><a href=\"/\">Pseudo Bank PIB</a></h1></div>\r\n    <div class=\"container\">\r\n        <div id=\"topcorners\"><div class=\"cleft\"></div><div class=\"cright\"></div></div>\r\n        <div id=\"content\">\r\n            \r\n\r\n\r\n\r\n\r\n            \r\n                <form name=\"f_0_11_1_3_1\" method=\"post\" action=\"/pib/LoginAction\">\r\n                    <table class=\"login\" style=\"margin-left: auto; margin-right: auto;\">\r\n                        <tr>\r\n                            <td><p class=\"mtop0 mbottom025\"><strong>\r\n                            You have been logged out of your Pseudo Bank Personal Internet Banking session due to one of the following reasons: \r\n\t\t\t\t\t\t<br></br>\t\t\t\r\n\t\t\t\t\t\t\t\t 1.\tYou have clicked on the \"Back\" and \"Refresh/Reload\" button on your internet browser \r\n\t\t\t\t\t\t<br></br>\t\t\r\n\t\t\t\t\t\t2. Your session has been inactive for more than 30 minutes. \r\n\t\t\t\t\t\t<br></br>\r\n\t\t\t\t\t\t 3. You have logged in for more than 90 minutes. \r\n\t\t\t\t\t\t<br></br>\t \r\n\t\t\t\t\t\t4. You attempted to change or bookmark the website address. \r\n\t\t\t\t\t\t<br></br>\r\n\t\t\t\t\t\t\tPlease login again.\r\n\t\t\t\t\t\t<br></br>\r\n\t\t\t\t\t\t</strong></p></td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td><p class=\"mtop0 mbottom025\"><strong><label for=\"email\">Username</label></strong></p><input id=\"userName\" tabindex=\"1\" class=\"inputtext\" type=\"userName\" name=\"userName\" /></td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td><p class=\"mtop05 mbottom025\"><strong><label for=\"password\">Password</label></strong></p><input tabindex=\"2\" class=\"inputtext\" type=\"password\" name=\"passWord\" id=\"passWord\" /></td>\r\n                        </tr>\r\n                      \r\n                        \r\n                        \r\n                        <tr>\r\n                            <td style=\"padding-top: 10px;\"><input class=\"bprimarypub80\" type=\"submit\" tabindex=\"4\" value=\"Login\" /></td>\r\n                        </tr>\r\n                    </table>\r\n                </form>\r\n            \r\n            \r\n        </div>\r\n        <div id=\"bottomcorners\"><div class=\"cleft\"></div><div class=\"cright\"></div></div>\r\n    </div>\r\n</div>\r\n        <div id=\"footer\">\r\n    <p>\r\n        <a href=\"/pib\">Home</a> <span>|</span>\r\n        <a href=\"#\">Privacy Policy</a> <span>|</span>\r\n        <a href=\"#\">Terms of Service</a> <span>|</span>\r\n\r\n    </p>\r\n    <p>Copyright &copy; 2011 Pseudo Bank. All rights reserved.</p>\r\n</div>\r\n\r\n    </body>\r\n</html>";
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
