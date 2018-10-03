package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

/**
 * Servlet implementation class addAccountServlet
 */
@WebServlet("/addAccountServlet")
public class addAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float balance = Float.parseFloat(request.getParameter("balance"));
		Account acc = new Account(name, balance);
		AccountHelper acch = new AccountHelper();
		acch.insertAccount(acc);
		getServletContext().getRequestDispatcher("/addAccount.html").forward(request, response);
	}

}
