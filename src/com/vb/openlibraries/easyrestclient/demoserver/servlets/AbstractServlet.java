package com.vb.openlibraries.easyrestclient.demoserver.servlets;

import javax.servlet.http.HttpServlet;

import com.googlecode.objectify.ObjectifyService;

import entities.DemoObject;

public abstract class AbstractServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
        ObjectifyService.register(DemoObject.class);
    }

}
	