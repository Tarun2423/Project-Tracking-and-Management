import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet.*;

import com.nimbusds.jose.shaded.gson.Gson;
public class SendMail extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setContentType("application/json");

        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/Project";
            String dbUsername="postgres";
            String dbPassword="root";
            String query="SELECT * FROM tasks WHERE TO_DATE(deadline, 'YYYY-MM-DD') < CURRENT_DATE and status <> 'Completed'";
            Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst=con.prepareStatement(query);
            ArrayList<Task> chartData = new ArrayList<Task>();
            ResultSet rs=pst.executeQuery();
            int noOfTasks=0,finished=0,unfinished=0;
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
                chartData.add(project);
            }
            
            Gson gson = new Gson();
            String json = gson.toJson(chartData);
            res.setContentType("application/json");
            res.getWriter().write(json);  
        
        }
        catch(Exception e) {
            res.getWriter().write("error");
        }
        
        }
        

	// private void sendEmail(String to, String subject, String body) {
	      
	//         Properties properties = new Properties();
	//         properties.put("mail.smtp.host", "smtp.gmail.com");
	//         properties.put("mail.smtp.port", "587");
	//         properties.put("mail.smtp.auth", "true");
	//         properties.put("mail.smtp.starttls.enable", "true");

	//         Session session = Session.getInstance(properties, new Authenticator() {
	//             protected PasswordAuthentication getPasswordAuthentication() {
	//                 return new PasswordAuthentication("taru19421.cs@rmkec.ac.in", "tarun@rmkec");
	//             }
	//         });

	//         try {

	//             Message message = new MimeMessage(session);

	//             message.setFrom(new InternetAddress("taru19421.cs@rmkec.ac.in"));

	//             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

	//             message.setSubject(subject);
	//             message.setText(body);

	//             Transport.send(message);

	//             System.out.println("Email sent successfully!");

	//         } catch (MessagingException e) {
	//             throw new RuntimeException(e);
	//         }
	//     }
        
        
        }