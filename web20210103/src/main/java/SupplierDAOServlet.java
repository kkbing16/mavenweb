import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;


/**
 * Servlet implementation class SupplierDAOServlet
 */
@WebServlet("/SupplierDAOServlet")
public class SupplierDAOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupplierDAOServlet() {
		super();
// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		String sname = request.getParameter("sname");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String street = request.getParameter("street");
		String method = request.getParameter("method");
		Supplier s1 = new Supplier();
		s1.setSupId(Integer.parseInt(sid));
		s1.setSupName(sname);
		s1.setState(state);
		s1.setCity(city);
		s1.setZip(zip);
		s1.setStreet(street);
		SupplierDAO dao = new SupplierDAO();
		if (method.equals("add"))
			dao.addSupplier(s1);
		if (method.equals("update")) {
			dao.editSupplier(s1);
		}
		if (method.equals("del"))
			dao.deleteSupplier(s1.getSupId());
		List<Supplier> result = dao.getAllSupplier();
		request.setAttribute("supplier", result);
		request.getRequestDispatcher("viewSupplier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		doGet(request, response);
	}
}