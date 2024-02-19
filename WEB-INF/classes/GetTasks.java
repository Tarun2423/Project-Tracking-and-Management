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
public class GetTasks extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setContentType("application/json");

        ArrayList<Task> projects = new ArrayList<Task>();
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/Project";
            String dbUsername="postgres";
            String dbPassword="root";
            String manager=req.getParameter("manager");
            String query="SELECT * FROM tasks where manager=?";
            Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, manager);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String pname=rs.getString("pname");
                String ename=rs.getString("ename");
                String tname=rs.getString("tname");
                String assignedon=rs.getString("assignedon");
                String deadline=rs.getString("deadline");
                String details=rs.getString("details");
                String status=rs.getString("status");
                Task project = new Task(id,pname,ename,tname,details,deadline,status,assignedon);
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