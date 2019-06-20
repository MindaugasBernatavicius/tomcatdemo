package cf.mindaugas.exB_globalization;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;


public class DetectLocale extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locale locale = request.getLocale();
		
		String language = locale.getLanguage();
		String country = locale.getCountry();
		String displayLanguage = locale.getDisplayLanguage();
		String displayCountry = locale.getDisplayCountry();
		String displayName = locale.getDisplayName();
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
			      
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Detecting Locale </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Language : " + language + "</p");
		out.println("<p>Display Language : " + displayLanguage + "</p>");
		out.println("<p>Country : " + country + "</p>");
		out.println("<p>Display Country : " + displayCountry + "</p>");
		out.println("<p>Display Name : " + displayName + "</p>");
		out.println("<hr />");
		Locale[] availableLocale = Locale.getAvailableLocales();
		for(Locale aLocale : availableLocale){
	        out.println("<p>Name of Locale: "+aLocale.getDisplayName());
	        out.println("<p>Language Code: "+aLocale.getLanguage()+", Language Display Name: "
	            +aLocale.getDisplayLanguage());
	        out.println("<p>Country Code: "+aLocale.getCountry()+", Country Display Name: "
	            +aLocale.getDisplayCountry());
	        if(!aLocale.getScript().equals("")){
	           out.println("<p>Script Code: "+aLocale.getScript()+", Script Display Name: "
	        		   	+aLocale.getDisplayScript());
	        }
	        if(!aLocale.getVariant().equals("")){
	           out.println("<p>Variant Code: "+aLocale.getVariant()+", Variant Display Name: "
	        		   +aLocale.getDisplayVariant());
	        }
	        out.println("<hr>");
	        }
		
		out.println("</body>");
		out.println("</html>");

	}

}
