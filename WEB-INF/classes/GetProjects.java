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
public class GetProjects extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setContentType("application/json");

        ArrayList<Project> projects = new ArrayList<Project>();
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/Project";
            String dbUsername="postgres";
            String dbPassword="root";
            String query="SELECT * FROM projects";
            Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst=con.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String assignedon=rs.getString("assignedon");
                String deadline=rs.getString("deadline");
                String details=rs.getString("details");
                String status=rs.getString("status");
                Project project = new Project(id,name,assignedon,deadline,status,details);
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