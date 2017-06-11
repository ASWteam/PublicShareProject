package com.example.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
	//한 페이지 당 보여줄 글 갯수 
	private int rowsPerPage = 3;
	 //페이지그룹안의 페이지 갯수
	private int pageGroupSize = 2;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 1;

		
		String p = request.getParameter("p");
		if (p != null && !p.equals("")) {
			try {
				currentPage = Integer.valueOf(p);
			} catch (Exception ignore) {}
		}
		
		request.setAttribute("boards", service.selectByLimit(currentPage, rowsPerPage));
		request.setAttribute("cp", currentPage);
		// 중요: 정수/정수 결과에서 소수점 이하는 버린다.
		// 페이징 처리에서 소수점은 1페이지를 의미하므로 버리지 말고 올림을 적용해야 한다.
		// 예) 2.1 ==> 3
		double tp = Math.ceil(service.count()/(double)rowsPerPage);
		request.setAttribute("tp", (int)tp);
		
		int pageGroupCount = service.count()/(rowsPerPage*pageGroupSize)+( service.count() % (rowsPerPage*pageGroupSize) == 0 ? 0 : 1);
		int numPageGroup = (int) Math.ceil((double)currentPage/pageGroupSize);
		request.setAttribute("count", new Integer(service.count()));
		request.setAttribute("pageSize", new Integer(rowsPerPage));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));

		String page = "/WEB-INF/jsp/board/list.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
