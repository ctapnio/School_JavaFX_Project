/**
 * Christian Tapnio
 * 991 359 879
 * Assignment 3
 */
package Student_JavaFX_Project.display;

import Student_JavaFX_Project.content.FileManager;
import Student_JavaFX_Project.content.Student;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayStage extends Stage {

    private ArrayList<Student> studentList = new ArrayList<>();

    public DisplayStage(ArrayList<Student> studentList) {
        this.studentList = studentList;
        setScene(addScene());
    }

    private Scene addScene() {
        String recordList = new String();
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            recordList += "Student " + one.getStudentId()
                    + ":\nObject Oriented Programming: " + one.getCourseOne()
                    + ",   Web Development: " + one.getCourseTwo()
                    + ",   Data Network & Design: " + one.getCourseThree()
                    + ",   Linux/UNIX Systems: " + one.getCourseFour()
                    + ",   Software Design Fundamentals: " + one.getCourseFive()
                    + ",   average: " + one.getStudentAvg() + "\n";
        }
        recordList += "\nCourse averages:\nObject Oriented Programming: " + calcCourseOneAvg()
                + ",   Web Development: " + calcCourseTwoAvg()
                + ",   Data Network & Design: " + calcCourseThreeAvg()
                + ",   Linux/UNIX Systems: " + calcCourseFourAvg()
                + ",   Software Design Fundamentals: " + calcCourseFiveAvg() + "\n\n"
                + "Overall Average: " + calcOverallAvg();

        final String record = recordList;
        TextArea txtRecords = new TextArea(recordList);
        txtRecords.setPrefSize(1140, 500);
        Alert alrtErr = new Alert(Alert.AlertType.ERROR);
        Alert alrtInfo = new Alert(Alert.AlertType.INFORMATION);
        Button btnSave = new Button("Save");
        btnSave.setLayoutX(1150);
        btnSave.setLayoutY(0);
        Button btnClose = new Button("Close");
        btnClose.setLayoutX(1150);
        btnClose.setLayoutY(40);

        btnClose.setOnAction((e) -> {
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });
        btnSave.setOnAction((e) -> {
            try {
                FileManager.setRecord("Records.dat", record);
            } catch (IOException ex) {
                alrtErr.setTitle("IOException message");
                alrtErr.setHeaderText("Error");
                alrtErr.setContentText("Cannot create file");

                alrtErr.showAndWait();
            }
            alrtInfo.setTitle("File Save");
            alrtInfo.setHeaderText("Saved");
            alrtInfo.setContentText("The file has been saved as Records.dat");
            alrtInfo.show();
            txtRecords.requestFocus();
        });

        Pane pane = new Pane(txtRecords, btnSave, btnClose);
        Scene scene = new Scene(pane, 1220, 500);
        return scene;
    }

    private int calcCourseOneAvg() {
        int courseOneAvg = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            courseOneAvg += one.getCourseOne();
        }
        return courseOneAvg / studentList.size();
    }

    private int calcCourseTwoAvg() {
        int courseTwoAvg = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            courseTwoAvg += one.getCourseTwo();
        }
        return courseTwoAvg / studentList.size();
    }

    private int calcCourseThreeAvg() {
        int courseThreeAvg = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            courseThreeAvg += one.getCourseThree();
        }
        return courseThreeAvg / studentList.size();
    }

    private int calcCourseFourAvg() {
        int courseFourAvg = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            courseFourAvg += one.getCourseFour();
        }
        return courseFourAvg / studentList.size();
    }

    private int calcCourseFiveAvg() {
        int courseFiveAvg = 0;
        for (int i = 0; i < studentList.size(); i++) {
            Student one = studentList.get(i);
            courseFiveAvg += one.getCourseFive();
        }
        return courseFiveAvg / studentList.size();
    }

    private int calcOverallAvg() {
        int overallAvg = (calcCourseOneAvg() + calcCourseTwoAvg()
                + calcCourseThreeAvg() + calcCourseFourAvg()
                + calcCourseFiveAvg()) / 5;
        return overallAvg;
    }
}
