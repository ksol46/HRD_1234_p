package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

@WebServlet("/")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;

		System.out.println(context + "," + command);

		MemberDAO member = new MemberDAO();

		switch (command) {
		case "/home" :
			site = "index.jsp";
			break;
		case "/insert" :
			site = member.insert(request, response);
			break;
		case "/add" :
			site = member.nextCustno(request, response);
			break;
		case "/list" :
			site = member.selectAll(request, response);
			break;
		case "/result" :
			site = member.selectResult(request, response);
			break;
		}
		
		getServletContext().getRequestDispatcher("/" + site).forward(request, response);
	}
}
