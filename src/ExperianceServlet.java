

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

@WebServlet("/ExperianceServlet")
public class ExperianceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession sessionSave = request.getSession();
			Class.forName("com.mysql.jdbc.Driver");  
			String url = "jdbc:mysql://localhost:3306/ResumeServlet?autoReconnect=true&useSSL=false";
			Connection con=DriverManager.getConnection(url,"root","jonathan");
			PreparedStatement ExpPrpr = null;
			String Company = request.getParameter("Company");
			String Position = request.getParameter("Position");
			String Experiance = request.getParameter("Experiance");
			ArrayList<String> newExpAL = (ArrayList<String>) sessionSave.getAttribute("ExpALSession");
			newExpAL.add(Company);
			newExpAL.add(Position);
			newExpAL.add(Experiance);

			sessionSave.setAttribute("ExpALSession", newExpAL);
			int IDSession = (int) sessionSave.getAttribute("IDSession");

			//System.out.println(IDSession);
			String ExpQuery = ("INSERT into Experiance " + "(`Company`, `Position`, `ExpYear`,`PersonID`) " + "VALUES (?,?,?,?)");

			ExpPrpr= con.prepareStatement(ExpQuery);	
			ExpPrpr.setString(1, Company);
			ExpPrpr.setString(2, Position);
			ExpPrpr.setString(3, Experiance);
			ExpPrpr.setInt(4, IDSession);
			ExpPrpr.executeUpdate();
			getServletContext().getRequestDispatcher("/Experiance.jsp").forward(request,response);
		}catch (Exception e) {
			System.out.println("ERROR");
		}
	}

}
