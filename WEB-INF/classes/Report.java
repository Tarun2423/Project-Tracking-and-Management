public class Report {
 int id;
 String from,to,report,tname,time;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getFrom() {
    return from;
}
public void setFrom(String from) {
    this.from = from;
}
public String getTo() {
    return to;
}
public void setTo(String to) {
    this.to = to;
}
public String getReport() {
    return report;
}
public void setReport(String report) {
    this.report = report;
}
public String getTname() {
    return tname;
}
public void setTname(String tname) {
    this.tname = tname;
}
public String getTime() {
    return time;
}
public void setTime(String time) {
    this.time = time;
}
public Report(int id, String from, String to, String report, String tname, String time) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.report = report;
    this.tname = tname;
    this.time = time;
}   
}
