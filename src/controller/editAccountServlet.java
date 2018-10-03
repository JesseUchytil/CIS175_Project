package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

/**
 * Servlet implementation class editAccountServlet
 */
@WebServlet("/editAccountServlet")
public class editAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editAccountServlet() {
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
		String action = request.getParameter("doThisToAccount");
		AccountHelper acch = new AccountHelper();
		if(action == null) {
			getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
		} else if (action.equals("Delete Selected Account")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Account toDelete = acch.findAccountById(tempId).get(0);
			acch.deleteAccount(toDelete);
			getServletContext().getRequestDispatcher("/viewAllAccountsServlet").forward(request, response);
		} else if (action.equals("Edit Selected Account")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Account toEdit = acch.findAccountById(tempId).get(0);
			request.setAttribute("accountToEdit", toEdit);
			getServletContext().getRequestDispatcher("/editAccount.jsp").forward(request, response);
		} else if (action.equals("Add New Account")) {
			getServletContext().getRequestDispatcher("/addAccount.html").forward(request, response);
		}
	}

}
