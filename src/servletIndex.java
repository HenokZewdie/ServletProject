
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletIndex")
public class servletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		try{
 			PreparedStatement person = null;
 			HttpSession sessionSave = request.getSession();
 	 		String FullName = request.getParameter("FullName");
 	 		String Email = request.getParameter("Email");
 	 		Class.forName("com.mysql.jdbc.Driver");  
 			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ResumeServlet",
 					"root","jonathan");
 	 		
 			sessionSave.setAttribute("FullNameSession", FullName);
 	 		sessionSave.setAttribute("EmailSession", Email);
 	 		String PQuery = ("INSERT into `ResumeServlet`.`Person`"
 					+ "(`FullName`, `Email`) "
 					+ "VALUES (?,?)");
 			person= con.prepareStatement(PQuery);
 			person.setString(1, FullName);
 			person.setString(2, Email);
 			person.executeUpdate();
 			
 			String ID = ("SELECT PersonID FROM Person WHERE Email = '"+Email+"'"); 
 			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(ID);
			rs.next();
			int PID= Integer.parseInt(rs.getString("PersonID"));
 	 		sessionSave.setAttribute("IDSession", PID);
 	 		//System.out.println(PID);
 	 		
 	 		ArrayList<String> EducAL = new ArrayList<String>();
 	 		sessionSave.setAttribute("EducALSession", EducAL);
 	 		
 	 		ArrayList<String> ExpAL = new ArrayList<String>();
 	 		sessionSave.setAttribute("ExpALSession", ExpAL);
 	 		
 	 		ArrayList<String> SkillAL = new ArrayList<String>();
 	 		sessionSave.setAttribute("SkillALSession", SkillAL);
 	 		
 	 		
 	 		//getServletContext().getRequestDispatcher("/Display.jsp").forward(request,response);
 	 		getServletContext().getRequestDispatcher("/Education.jsp").forward(request,response);
 		}catch (Exception e) {
			System.out.println("Error");
		}
 		
 		
	}

}
