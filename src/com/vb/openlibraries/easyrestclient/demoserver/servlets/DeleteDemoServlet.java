package com.vb.openlibraries.easyrestclient.demoserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import entities.DemoObject;

public class DeleteDemoServlet extends AbstractServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			ObjectifyService.ofy().delete().type(DemoObject.class).id(id).now();
			resp.setStatus(200);
		} else {
			resp.setStatus(400);
		}

	}

}
