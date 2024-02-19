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
public class GetReport extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setContentType("application/json");

        ArrayList<Report> projects = new ArrayList<Report>();
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/Project";
            String dbUsername="postgres";
            String dbPassword="root";
            String manager=req.getParameter("manager");
            String query="SELECT * FROM report where toe=?";
            Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, manager);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String tname=rs.getString("tname");
                String from=rs.getString("frome");
                String to=rs.getString("toe");
                String report=rs.getString("report");
                String date=rs.getString("time");
                Report project = new Report(id,from,to,report,tname,date);
                projects.add(project);
            }
            Gson gson = new Gson();
            String json = gson.toJson(projects);
            res.setContentType("application/json");
            res.getWriter().write(json);  
        
        }
        catch(Exception e) {
            res.getWriter().write("error");
        }
        
        }
        
        
        }