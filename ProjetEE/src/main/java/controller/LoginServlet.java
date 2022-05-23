package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DAO.AdminDAO;
import DAO.AdminDaoImp;
import DAO.DAOFactory;
import Model.Admin;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER="userInf";
  
	AdminDAO adminDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		Admin userSession=(Admin)session.getAttribute(ATT_USER);
		String logout=request.getParameter("logout");
		if(userSession != null) {
			if(logout != null) {
				if (logout.equals("1")) {
					session.invalidate();
					this.getServletContext().getRequestDispatcher("/Vue/login.jsp").forward(request,response);
				}else {
					RequestDispatcher req = request.getRequestDispatcher("home");
					req.forward(request, response);
				}
			}else {
				this.getServletContext().getRequestDispatcher("/home").forward(request,response);
			}

		}else {
			this.getServletContext().getRequestDispatcher("/Vue/login.jsp").forward(request,response);
		}
	
	
	
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.isEmpty() || password.isEmpty() )
		{
			String resultat ="vous devez remplir tous les champs SVP !!";
        	request.setAttribute ("resultat" , resultat ) ;
			RequestDispatcher req = request.getRequestDispatcher("/Vue/login.jsp");
			req.include(request, response);
		}
		else
		{
			
			DAOFactory factory=DAOFactory.getInstance();
			
			AdminDaoImp admin= (AdminDaoImp) factory.getAdminDao();
			
			boolean existe = admin.getAdmin(email, password);
			
			if(existe) {
				Admin c = admin.getInfosAdmin(email);
				HttpSession session = request.getSession(true);	
				session.setAttribute(ATT_USER, c);
				RequestDispatcher req = request.getRequestDispatcher("/Vue/inscription.jsp");
				req.forward(request, response);
			}else {
				String resultat ="Login ou password incorrect !";
	        	request.setAttribute ("resultat" , resultat ) ;
				RequestDispatcher req = request.getRequestDispatcher("/Vue/login.jsp");
				req.include(request, response);
			}
			
		}
	}

}
