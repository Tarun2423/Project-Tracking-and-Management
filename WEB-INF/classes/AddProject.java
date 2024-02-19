import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;

import com.nimbusds.jose.shaded.gson.Gson;
public class AddProject extends HttpServlet{

protected void doPost(HttpServletRequest req, HttpServletResponse res){
    res.setHeader("Access-Control-Allow-Origin","*");
    res.setContentType("text/html");

    String url = "jdbc:postgresql://localhost:5432/Project";
    String dbUsername = "postgres";
    String dbPassword = "root";
    String query="INSERT INTO projects(name,assignedon,deadline,status,details) VALUES(?,?,?,?,?)";
    String name=req.getParameter("name");
    String deadline=req.getParameter("deadline");
    String details=req.getParameter("details");
    Date today = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String assignedon=dateFormat.format(today);
    System.out.println(name);
    System.out.println(assignedon);
    System.out.println(deadline);
    try {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, assignedon);
        pst.setString(3, deadline);
        pst.setString(4, "in progress");
        pst.setString(5, details);
        pst.executeUpdate();
        res.getWriter().println("success");
        con.close();
	       
    }catch (Exception e) {
        
        System.out.print("some error");
    }
    

}

}
