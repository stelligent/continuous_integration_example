package com.beer.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beer.business.domain.Beer;
import com.beer.business.service.BeerService;
import com.beer.business.service.BeerServiceImpl;
import com.beer.business.service.LoginService;
import com.beer.business.service.LoginServiceImpl;
import com.beer.business.service.UserException;

public class ServletController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String BEER_PAGE = "beer";

	private static final String LOGIN_PAGE = "index";

	private static final String EDIT_BEER_PAGE = "editbeer";

	private static final String ERROR_PAGE = "error";

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		// getParameter is an example of getting a parameter from an HTML form
		String fromPage = req.getParameter("FROM_PAGE");
		String toPage = req.getParameter("TO_PAGE");
		String returnPage = null;
		System.out.println("In FROM_PAGE=" + fromPage);
		System.out.println("In TO_PAGE=" + toPage);
		processRequest(req);
		if (fromPage != null && fromPage.equalsIgnoreCase(LOGIN_PAGE)) {
			LoginService loginService = new LoginServiceImpl();
			try {
				loginService.login(req.getParameter("username"), req
						.getParameter("password"));
			} catch (UserException e) {
				toPage = ERROR_PAGE;
			}

			BeerService beerService = new BeerServiceImpl();
			StringBuffer beerBuffer = new StringBuffer("Index Beer: ");
			Collection beer = beerService.findAll();
			for (Iterator it = beer.iterator(); it.hasNext();) {
				Beer element = (Beer) it.next();
				beerBuffer.append(element.getBrewer());
				beerBuffer.append("=" + element.getName());
				beerBuffer.append("</br>");
			}
			req.setAttribute("beer", beerBuffer.toString());
			req.setAttribute("userMessage", "Logged in as "
					+ req.getParameter("username"));
		}

		if (fromPage != null && fromPage.equalsIgnoreCase(EDIT_BEER_PAGE)) {
			Beer beer = new Beer();
			beer.setBrewer(req.getParameter("brewer"));
			beer.setName(req.getParameter("beer_name"));
			beer.setDateReceived("2006-08-20");
			BeerService beerService = new BeerServiceImpl();
			beerService.create(beer);

		}

		returnPage = toPage + ".jsp";
		System.out.println("returnPage=" + returnPage);
		RequestDispatcher rd = req.getRequestDispatcher(returnPage);
		rd.forward(req, res);
	}

	public Map processRequest(HttpServletRequest req) {
		Enumeration enumeration1 = null;
		Map attributeMap = new HashMap();
		enumeration1 = req.getParameterNames();
		do {
			if (!enumeration1.hasMoreElements())
				break;
			String s2 = (String) enumeration1.nextElement();
			if (s2 != null && (s2 instanceof String)) {
				String s3 = req.getParameter((String) s2);
				System.out.println("ELEMENTs2:" + s2);
				System.out.println("ELEMENTs3:" + s3);
				attributeMap.put(s2, s3);
			}
		} while (true);
		return attributeMap;
	}

}
