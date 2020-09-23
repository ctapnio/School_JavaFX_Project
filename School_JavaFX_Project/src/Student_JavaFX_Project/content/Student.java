/**
 * Christian Tapnio
 * 991 359 879
 * Assignment 3
 */
package Student_JavaFX_Project.content;

public class Student {

    private int studentId;
    private int studentAvg;
    private int courseOne;
    private int courseTwo;
    private int courseThree;
    private int courseFour;
    private int courseFive;

    public int getCourseOne() {
        return courseOne;
    }

    public void setCourseOne(int courseOne) {
        this.courseOne = courseOne;
    }

    public int getCourseTwo() {
        return courseTwo;
    }

    public void setCourseTwo(int courseTwo) {
        this.courseTwo = courseTwo;
    }

    public int getCourseThree() {
        return courseThree;
    }

    public void setCourseThree(int courseThree) {
        this.courseThree = courseThree;
    }

    public int getCourseFour() {
        return courseFour;
    }

    public void setCourseFour(int courseFour) {
        this.courseFour = courseFour;
    }

    public int getCourseFive() {
        return courseFive;
    }

    public void setCourseFive(int courseFive) {
        this.courseFive = courseFive;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentAvg() {
        calcStudentAvg();
        return studentAvg;
    }

    public void calcStudentAvg() {
        this.studentAvg = (courseOne + courseTwo
                + courseThree + courseFour
                + courseFive) / 5;
    }
    
    
 
   
}
