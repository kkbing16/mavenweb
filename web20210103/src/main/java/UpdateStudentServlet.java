

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import model.Student;
/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("web20210103");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("update Student SET age=:age,sname=:sname where sid=:sid");
		query.setParameter("sid",Integer.parseInt(request.getParameter("sid")));
		query.setParameter("sname", request.getParameter("sname"));
		query.setParameter("age", Integer.parseInt(request.getParameter("age")));
		int r=query.executeUpdate();
		if(r>0)
			System.out.println("update successfully");
		else
			System.out.println("update failed");
		Query query2 = em.createQuery("Select s from Student s ");
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) query2.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		request.setAttribute("students", list);
		request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
