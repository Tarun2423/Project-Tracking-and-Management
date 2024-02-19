
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@MultipartConfig
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		
            System.out.println("inn");
		 	String url = "jdbc:postgresql://localhost:5432/Project";
		    String dbUsername = "postgres";
		    String dbPassword = "root";
		    String query="INSERT INTO users(name,password,email,role,joining,profileimg,dob,reportingto,phone) VALUES(?,?,?,?,?,?,?,?,?)";
		    String name=req.getParameter("name");
		    String password=req.getParameter("password");
		    String email=req.getParameter("email");
		    String role=req.getParameter("role");
		    String dob=req.getParameter("dob");
		    String man=req.getParameter("man");
		    String mob=req.getParameter("mob");
	        Part filePart = req.getPart("file");
	        byte[] imageData = getByteArrayFromInputStream(filePart.getInputStream());
	      
			Date today = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        String joining=dateFormat.format(today);
			System.out.println(name);
			System.out.println(role);
			
			try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url, dbUsername, dbPassword);
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, role);
			pst.setString(5, joining);
			pst.setBytes(6, imageData);
			pst.setString(7, dob);
			pst.setString(8, man);
			pst.setString(9, mob);
			
			pst.executeUpdate();
			System.out.println("Successfully added");
			res.getWriter().println("success");
		

			con.close();
	       
		}catch (Exception e) {
			
			System.out.print("some error");
		}
		
		
	}

	 private byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException {
		 try {
             byte[] buffer = new byte[inputStream.available()];
             inputStream.read(buffer);
             return buffer;
         } finally {
             inputStream.close();
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
 
    

