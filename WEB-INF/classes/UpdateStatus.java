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
public class UpdateStatus extends HttpServlet{

protected void doPost(HttpServletRequest req, HttpServletResponse res){
    res.setHeader("Access-Control-Allow-Origin","*");
    res.setContentType("text/html");

    String url = "jdbc:postgresql://localhost:5432/Project";
    String dbUsername = "postgres";
    String dbPassword = "root";
    String query="Update tasks set status=? where id=?";
    String id=req.getParameter("id");
  int iid=Integer.parseInt(id);
  String status="Completed";
    try {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,status);
        pst.setInt(2, iid);
        pst.executeUpdate();
        res.getWriter().println("success");
        con.close();
	       
    }catch (Exception e) {
        
        System.out.print("some error");
    }
    

}

}
