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
public class AddReport extends HttpServlet{

protected void doPost(HttpServletRequest req, HttpServletResponse res){
    res.setHeader("Access-Control-Allow-Origin","*");
    res.setContentType("text/html");

    String url = "jdbc:postgresql://localhost:5432/Project";
    String dbUsername = "postgres";
    String dbPassword = "root";
    String query="INSERT INTO report(tname,frome,toe,report,time) VALUES(?,?,?,?,?)";
    String tname=req.getParameter("tname");
    String from=req.getParameter("from");
    String to=req.getParameter("to");
    String report=req.getParameter("report");
    Date today = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String time=dateFormat.format(today);

    try {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, tname);
        pst.setString(2, from);
        pst.setString(3, to);
        pst.setString(4, report);
        pst.setString(5, time);
        pst.executeUpdate();
        res.getWriter().println("success");
        con.close();
	       
    }catch (Exception e) {
        
        System.out.print("some error");
    }
    

}

}
