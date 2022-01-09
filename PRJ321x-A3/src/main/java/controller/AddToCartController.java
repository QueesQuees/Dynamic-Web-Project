package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*Controller của chức năng thêm một sản phẩm vào giỏ hàng*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html;charset=UTF-8");
    	
    	
    	try {
			HttpSession session = request.getSession(true);
			String idd = request.getParameter("id");
			String action = request.getParameter("action");
			if (action != null && action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
				}
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProduct("" + id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(), p.getBrand(), 1));
				request.getRequestDispatcher("cart.jsp").forward(request, response);
				
			} else if (action != null && action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
			}
			
			//response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println(e);
		}
    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
