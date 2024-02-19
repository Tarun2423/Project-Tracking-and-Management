public class Task {
    int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    public String getDetails() {
        return details;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getDeadline() {
        return deadline;
    }
    public String getAssignedon() {
        return assignedon;
    }
    public void setAssignedon(String assignedon) {
        this.assignedon = assignedon;
    }
    public Task(int id,String pname,String ename,String tname,String details,String deadline,String status,String assignedon) {
        this.id = id;
        this.pname = pname;
        this.ename = ename;
        this.tname = tname;
        this.details = details;
        this.deadline = deadline;
        this.status = status;
        this.assignedon = assignedon;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    String pname,ename,tname,details,deadline,status,assignedon;
 
}
