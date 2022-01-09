package controller.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.AccountDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User(email, password);
			if (!user.regexUser()) {
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);

			}

			AccountDAO account = new AccountDAO();
			try {
				out.write("sai o day 1");
				if (account.login(email, password)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);

					request.getRequestDispatcher("/index.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "Email address or password no recognised");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					out.write("sai o day 2");
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}

		/* register */
		if (action.equals("doregister")) {
			String email = request.getParameter("email");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String repeatpassword = request.getParameter("repeatpassword");
			request.setAttribute("email", email);
			if (!password.equals(repeatpassword)) {
				request.setAttribute("message", "Password do not match.");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

			User user = new User(email, password, userName);

			if (!user.regexUser()) {
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}

			AccountDAO account = new AccountDAO();
			try {
				if (account.exists(email)) {
					// neu use da ton tao trong database
					request.setAttribute("message", "Account is exists.");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				out.write("sai o day 3");
				e.printStackTrace();
				
			}

			// tao ra tai khoan moi

			try {
					out.write("sai o day 1");
					if (account.create(user.getEmail(),user.getPassword(), 1 , user.getUserName()) == 1) {
						out.write("sai o day 3 ");
						HttpSession session = request.getSession();
						session.setAttribute("user", user);
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					}	else {
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}
					
				
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				out.write("sai o day 4");
				e.printStackTrace();
			}
			
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestProcess(request, response);
	}

}
