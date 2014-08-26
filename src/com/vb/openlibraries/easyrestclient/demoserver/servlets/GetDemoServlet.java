package com.vb.openlibraries.easyrestclient.demoserver.servlets;

import helpers.JsonHelper;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import entities.DemoObject;

public class GetDemoServlet extends AbstractServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<DemoObject> list = ObjectifyService.ofy().load().type(DemoObject.class).list();
		resp.setContentType("application/json");
		resp.getWriter().println(JsonHelper.getInstence().toJson(list));
	}


}
