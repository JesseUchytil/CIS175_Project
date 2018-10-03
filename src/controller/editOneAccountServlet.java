package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

/**
 * Servlet implementation class editOneAccountServlet
 */
@WebServlet("/editOneAccountServlet")
public class editOneAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOneAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountHelper acch = new AccountHelper();
		String name = request.getParameter("name");
		float balance = Float.parseFloat(request.getParameter("balance"));
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		Account toUpdate = new Account();
		toUpdate.setId(tempId);
		toUpdate.setAccount_name(name);
		toUpdate.setAccount_balance(balance);
		
		acch.updateAccount(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
	}

}
