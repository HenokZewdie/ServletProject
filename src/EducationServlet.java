

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionSave
 */
@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		HttpSession sessionSave = request.getSession();
		Class.forName("com.mysql.jdbc.Driver");  
		String url = "jdbc:mysql://localhost:3306/ResumeServlet?autoReconnect=true&useSSL=false";
		Connection con=DriverManager.getConnection(url,"root","jonathan");
		PreparedStatement Education = null;
		
		String University = request.getParameter("University");
		String Major = request.getParameter("Major");
		String Year = request.getParameter("Year");
		
		ArrayList<String> newEduc = (ArrayList<String>) sessionSave.getAttribute("EducALSession");
		newEduc.add(University);
		newEduc.add(Major);
		newEduc.add(Year);
		
		sessionSave.setAttribute("EducALSession", newEduc);
		
	 		int IDSession = (int) sessionSave.getAttribute("IDSession");
	 		
	 		//System.out.println(IDSession);
	 		String EduQuery = ("INSERT into Education "	+ "(`University`, `Major`, `Year`,`PersonID`) " + "VALUES (?,?,?,?)");
	 	
	 		Education= con.prepareStatement(EduQuery);	
	 		Education.setString(1, University);
	 		Education.setString(2, Major);
	 		Education.setString(3, Year);
	 		Education.setInt(4, IDSession);
	 		Education.executeUpdate();

		
		
		getServletContext().getRequestDispatcher("/Education.jsp").forward(request,response);
		}catch (Exception e) {
			System.out.println("Error");
		}
	}

}
