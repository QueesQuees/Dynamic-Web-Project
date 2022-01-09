package controller.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws UnsupportedEncodingException, ServletException, IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*Controller login and logout*/
     protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException, IOException {
    	 response.setContentType("text/html;charset=UTF-8");
     	 request.setCharacterEncoding("utf-8");
     	 String action = request.getParameter("action");
     	 Map<String, String> actionMap =  new HashMap<>();
     	 actionMap.put("login", "/login.jsp");
     	 actionMap.put("register", "/register.jsp");
     	 actionMap.put("list", "/list.jsp");
     	 if(action == null || !actionMap.containsKey(action) ) action = "list";
     	 
     	 request.getRequestDispatcher(actionMap.get(action)).forward(request, response);
     }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestProcess(request, response);
	}

}
