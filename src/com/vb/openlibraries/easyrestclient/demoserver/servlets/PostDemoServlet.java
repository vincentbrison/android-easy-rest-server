package com.vb.openlibraries.easyrestclient.demoserver.servlets;

import helpers.JsonHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

import entities.DemoObject;

public class PostDemoServlet extends AbstractServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DemoObject objectToStore = JsonHelper.getInstence().fromJson(req.getParameter("object"), DemoObject.class);
		if (objectToStore != null) {
			ObjectifyService.ofy().save().entity(objectToStore).now();
			resp.setStatus(200);
		} else {
			resp.setStatus(400);
		}
	}

}
