package com.vb.openlibraries.easyrestclient.demoserver;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Easy_restclient_demoserverServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
