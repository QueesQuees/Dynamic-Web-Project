package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;

/**
 * Servlet implementation class InformationProductController
 */
@WebServlet("/InformationProductController")
public class InformationProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*controller của chức năng xem thông tin chi tiết của một sản phẩm*/
    protected void processRequest(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	
    	try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("product", new ListProductDAO().getProduct("" + id));
			request.getRequestDispatcher("infoProduct.jsp").forward(request, response);			
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println(e);
		}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(response, request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(response, request);
	}
}
