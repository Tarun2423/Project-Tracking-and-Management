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
public class AddTask extends HttpServlet{

protected void doPost(HttpServletRequest req, HttpServletResponse res){
    res.setHeader("Access-Control-Allow-Origin","*");
    res.setContentType("text/html");

    String url = "jdbc:postgresql://localhost:5432/Project";
    String dbUsername = "postgres";
    String dbPassword = "root";
    String query="INSERT INTO tasks(pname,ename,tname,details,deadline,status,assignedon,manager) VALUES(?,?,?,?,?,?,?,?)";
    String pname=req.getParameter("pname");
    String ename=req.getParameter("ename");
    String tname=req.getParameter("tname");
    String manager=req.getParameter("manager");
    String details=req.getParameter("details");
    String deadline=req.getParameter("deadline");
    Date today = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String assignedon=dateFormat.format(today);
    
    System.out.println(assignedon);
    System.out.println(deadline);
    try {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, pname);
        pst.setString(2, ename);
        pst.setString(3, tname);
        pst.setString(4, details);
        pst.setString(5, deadline);
        pst.setString(6, "in progress");
        pst.setString(7, assignedon);
        pst.setString(8, manager);
        pst.executeUpdate();
        res.getWriter().println("success");
        con.close();
	       
    }catch (Exception e) {
        
        System.out.print("some error");
    }
    

}

}
