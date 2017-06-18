

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

@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession sessionSave = request.getSession();

			Class.forName("com.mysql.jdbc.Driver");  
			String url = "jdbc:mysql://localhost:3306/ResumeServlet?autoReconnect=true&useSSL=false";
			Connection con=DriverManager.getConnection(url,"root","jonathan");
			PreparedStatement SkillPrpr = null;

			String Skill = request.getParameter("Skill");
			String Rating = request.getParameter("Rating");

			ArrayList<String> newSkillAL1 = (ArrayList<String>) sessionSave.getAttribute("SkillALSession");
			newSkillAL1.add(Skill);
			newSkillAL1.add(Rating);

			sessionSave.setAttribute("SkillSession", newSkillAL1);
			int IDSession = (int) sessionSave.getAttribute("IDSession");

			//System.out.println(IDSession);
			String EduQuery = ("INSERT into Skill " + "(`SkillName`, `Rating`,`PersonID`) " + "VALUES (?,?,?)");

			SkillPrpr= con.prepareStatement(EduQuery);	
			SkillPrpr.setString(1, Skill);
			SkillPrpr.setString(2, Rating);
			SkillPrpr.setInt(3, IDSession);

			SkillPrpr.executeUpdate();
			getServletContext().getRequestDispatcher("/Skill.jsp").forward(request,response);
		}catch (Exception e) {
			System.out.println("ERROR");
		}
	}

}
