package mall.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.dao.ProductDaoImpl;
import mall.dto.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String prefix = "/WEB-INF/jsp/";
	String suffix = ".jsp";
	private ProductDaoImpl pro = new ProductDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "product";
		String action = request.getParameter("action");
		boolean isProduct = false;
		String list = request.getParameter("id");

		if (action != null && !action.equals("")) {
			switch (action) {
			case "detail":				
				if (list != null && !list.equals("")) {
					Product p = pro.init(Integer.parseInt(list));
					isProduct = true;
					request.setAttribute("isProduct", isProduct);
					request.setAttribute("product", p);
				}
				break;
			}
		} else {
			List<Product> products = pro.findAll();
			request.setAttribute("products", products);
		}		
		request.getRequestDispatcher(prefix+page+suffix).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}
}
