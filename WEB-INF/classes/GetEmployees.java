import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;

import com.nimbusds.jose.shaded.gson.Gson;

public class GetEmployees extends HttpServlet{

protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{

res.setHeader("Access-Control-Allow-Origin", "*");
res.setContentType("text/html");
ArrayList<User> users = new ArrayList<User>();
String rname=req.getParameter("user");
try{
    Class.forName("org.postgresql.Driver");
    String url="jdbc:postgresql://localhost:5432/Project";
    String dbUsername="postgres";
    String dbPassword="root";
    String query="";
    if(rname.equals("admin")){

        query="SELECT * FROM users WHERE id <> 1";
        Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String role=rs.getString("role");
            String reportingto=rs.getString("reportingto");
            String email=rs.getString("email");
            String dob=rs.getString("dob");
            String joining=rs.getString("joining");
            String phone=rs.getString("phone");
            User user = new User(id,name,role,joining,dob,phone,reportingto,email);
            users.add(user);
        }
        Gson gson = new Gson();
        String json = gson.toJson(users);
        res.setContentType("application/json");
        res.getWriter().write(json);  
    
    }
    
    else{
        query="SELECT * FROM users WHERE reportingto=?";
    
    Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
    PreparedStatement pst=con.prepareStatement(query);
    pst.setString(1, rname);
    ResultSet rs=pst.executeQuery();
    while(rs.next()){
        int id=rs.getInt("id");
        String name=rs.getString("name");
        String role=rs.getString("role");
        String reportingto=rs.getString("reportingto");
        String email=rs.getString("email");
        String dob=rs.getString("dob");
        String joining=rs.getString("joining");
        String phone=rs.getString("phone");
        User user = new User(id,name,role,joining,dob,phone,reportingto,email);
        users.add(user);
    }
    Gson gson = new Gson();
	String json = gson.toJson(users);
	res.setContentType("application/json");
	res.getWriter().write(json);  

    
}
}
catch(Exception e) {
    res.getWriter().write("error");
}
}
}



