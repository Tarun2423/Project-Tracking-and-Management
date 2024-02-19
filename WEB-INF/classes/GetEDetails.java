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
public class GetEDetails extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setContentType("application/json");

        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/Project";
            String dbUsername="postgres";
            String dbPassword="root";
            String pname=req.getParameter("pname");
            String query="SELECT * FROM tasks where ename=?";
            Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, pname);
            ResultSet rs=pst.executeQuery();
            int noOfTasks=0,finished=0,unfinished=0;
            while(rs.next()){
                noOfTasks++;
                String status=rs.getString("status");
                if(status.equals("Completed")){
                    finished++;
                }
                else{
                    unfinished++;
                }
            }
            ArrayList<ChartData> chartData = new ArrayList<ChartData>();
            ChartData ch=new ChartData(noOfTasks,finished,unfinished);
            chartData.add(ch);
            Gson gson = new Gson();
            String json = gson.toJson(chartData);
            res.setContentType("application/json");
            res.getWriter().write(json);  
        
        }
        catch(Exception e) {
            res.getWriter().write("error");
        }
        
        }
        
        
        }