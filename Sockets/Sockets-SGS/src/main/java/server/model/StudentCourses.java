package server.model;

public class StudentCourses {

    private String courseName;
    private String studentEmail;
    private int mark;

    public StudentCourses(String courseName, String studentEmail, int mark) {
        this.courseName = courseName;
        this.studentEmail = studentEmail;
        this.mark = mark;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
