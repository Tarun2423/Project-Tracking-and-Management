public class Project {
    int id;
    String name,assignedon,deadline,status,details;
    public Project(int id, String name, String assignedon, String deadline, String status, String details) {
        this.id = id;
        this.name = name;
        this.assignedon = assignedon;
        this.deadline = deadline;
        this.status = status;
        this.details = details;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAssignedon() {
        return assignedon;
    }
    public void setAssignedon(String assignedon) {
        this.assignedon = assignedon;
    }
    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
