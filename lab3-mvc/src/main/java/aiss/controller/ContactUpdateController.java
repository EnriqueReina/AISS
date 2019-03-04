package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Contact;
import aiss.model.repository.ContactRepository;

/**
 * Servlet implementation class DeleteContactController
 */
public class ContactUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Contact c = ContactRepository.getInstance().getContact(id);
		
		if(name == null && phone == null)
		{
			request.setAttribute("contact", c);
			request.getRequestDispatcher("/contactEditView.jsp").forward(request, response);
		}
		
		if(name != null && phone != null)
		{
			c.setName(name);
			c.setTelephone(phone);
			ContactRepository.getInstance().updateContact(c);
			request.setAttribute("message", "Update done correctly");
			request.getRequestDispatcher("/contactlist").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
