package com.shit.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shit.dao.UCalendarDaoImpl;
import com.shit.dto.UCalendar;

@WebServlet("/calendar")
public class UCalendarServlet extends HttpServlet {

	private static final long serialVersionUID = -1753431335407698266L;
	private UCalendarDaoImpl dao = new UCalendarDaoImpl();
	List<UCalendar> ucal;
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ucal = dao.findAll();

		req.setAttribute("calendar", ucal);

		String json = gson.toJson(ucal);
		res.setContentType("application/json; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		UCalendar cal = new UCalendar();
		int id = 0;
		try {
			System.out.println(action);
			if (action != null) {
				System.out.println("switch");
				switch (action) {
				case "add": {
					cal.setTitle(req.getParameter("title"));
					cal.setStartdate(req.getParameter("start"));
					cal.setEnddate(req.getParameter("end"));
					System.out.println(cal);
					dao.add(cal);
					String json = gson.toJson(cal);
					res.setContentType("application/json; charset=UTF-8");
					PrintWriter out = res.getWriter();
					out.print(json);
					break;
				}
				case "modify": {
					cal.setId(Integer.parseInt(req.getParameter("id")));
					cal.setTitle(req.getParameter("title"));
					cal.setStartdate(req.getParameter("start"));
					cal.setEnddate(req.getParameter("end"));
					System.out.println(cal);
					System.out.println("----------");
					dao.modify(cal);
					String json = gson.toJson(cal);
					System.out.println(json);
					res.setContentType("application/json; charset=UTF-8");
					PrintWriter out = res.getWriter();
					out.print(json);
					break;
				}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 서블릿이 처리를 해 주지 않아서 받을 수 없다.
		// String id = req.getParameter("id");
		// System.out.println(id);

		/*
		 * Unlike in doGet() and doPost() methods, we are not able to get the
		 * request parameters using the getParameter() method in doPut() and
		 * doDelete() methods. We need to retrieve them manually from the input
		 * stream.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String data = br.readLine();
		System.out.println(data);

		// data = unescape(URLDecoder.decode(data, "UTF-8"), true); // 한글 처리

		Map<String, String> map = new HashMap<>();
		String[] parameter = data.split("&");
		for (int i = 0; i < parameter.length; i++) {
			String parameterTemp[] = parameter[i].split("=");
			String name = parameterTemp[0];
			String value = parameterTemp[1];
			map.put(name, value);
		}

		System.out.println(map);

		int id = Integer.parseInt(map.get("id"));

		// 삭제를 하고 삭제성공을 응답한다.
		List<UCalendar> cal = dao.findById(id);

		if (cal != null) {
			System.out.println(id);
			dao.remove(id);

			res.setContentType("application/json; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.print("{\"result\":\"success\"}");
		} else {
			res.setContentType("application/json; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.print("{\"result\":\"fail\"}");
		}

	}

}
