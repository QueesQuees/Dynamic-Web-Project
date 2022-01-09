package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*controller của chức năng tìm kiếm product dành cho quản trị hệ thống*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()){
			String name = request.getParameter("search");
			List<Product> ls = new ListProductDAO().search(name);
			request.setAttribute("products", ls);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, e);
		}
    }
}
