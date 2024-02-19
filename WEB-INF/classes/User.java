

public class User {

    int empid;
  byte[] image;
  String name,role,joining,dob,phone,reportingto,email;
   
  
    public User(int empid, byte[] image, String name, String role, String joining, String dob, String phone,
        String reportingto, String email) {
    this.empid = empid;
    this.image = image;
    this.name = name;
    this.role = role;
    this.joining = joining;
    this.dob = dob;
    this.phone = phone;
    this.reportingto = reportingto;
    this.email = email;
}
public User(int empid,  String name, String role, String joining, String dob, String phone,
String reportingto, String email) {
this.empid = empid;

this.name = name;
this.role = role;
this.joining = joining;
this.dob = dob;
this.phone = phone;
this.reportingto = reportingto;
this.email = email;
}


    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getJoining() {
        return joining;
    }
    public void setJoining(String joining) {
        this.joining = joining;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getReportingto() {
        return reportingto;
    }
    public void setReportingto(String reportingto) {
        this.reportingto = reportingto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
