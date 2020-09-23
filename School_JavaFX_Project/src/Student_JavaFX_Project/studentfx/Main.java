/**
 * Christian Tapnio
 * 991 359 879
 * Assignment 3
 */
package Student_JavaFX_Project.studentfx;

import Student_JavaFX_Project.display.DisplayStage;
import Student_JavaFX_Project.content.Student;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    ArrayList<Student> studentList = new ArrayList<>();
    Label lblStudentId = new Label("  Student ID: ");
    TextField txtStudentId = new TextField();

    Label lblCourse = new Label("  Courses");

    Label lblCourse1 = new Label("  Object Oriented Programming: ");
    TextField txtCourse1 = new TextField();

    Label lblCourse2 = new Label("  Web Development 2: ");
    TextField txtCourse2 = new TextField();

    Label lblCourse3 = new Label("  Data Networking & Design: ");
    TextField txtCourse3 = new TextField();

    Label lblCourse4 = new Label("  Linux/ UNIX Systems: ");
    TextField txtCourse4 = new TextField();

    Label lblCourse5 = new Label("  Software Design Fundamentals: ");
    TextField txtCourse5 = new TextField();

    Button btnAdd = new Button("Add");
    Button btnDisplay = new Button("Show Record");

    @Override
    public void start(Stage primaryStage) {
        btnAdd.setOnAction((e) -> {
            addStudent();
            txtStudentId.clear();
            txtCourse1.clear();
            txtCourse2.clear();
            txtCourse3.clear();
            txtCourse4.clear();
            txtCourse5.clear();
            txtStudentId.requestFocus();
        });
        btnDisplay.setOnAction((e) -> {
            DisplayStage ds = new DisplayStage(studentList);
            txtStudentId.requestFocus();
            ds.show();
        });
        Scene scene = new Scene(addPane(), 425, 340);
        primaryStage.setTitle("School Record");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Student addStudent() {
        Student one = new Student();
        int id = Integer.parseInt(txtStudentId.getText());
        int course1 = Integer.parseInt(txtCourse1.getText());
        int course2 = Integer.parseInt(txtCourse2.getText());
        int course3 = Integer.parseInt(txtCourse3.getText());
        int course4 = Integer.parseInt(txtCourse4.getText());
        int course5 = Integer.parseInt(txtCourse5.getText());

        one.setStudentId(id);
        one.setCourseOne(course1);
        one.setCourseTwo(course2);
        one.setCourseThree(course3);
        one.setCourseFour(course4);
        one.setCourseFive(course5);

        studentList.add(one);
        return one;
    }

    private Pane addPane() {
        GridPane gPane = new GridPane();
        gPane.setVgap(10);
        gPane.setHgap(10);
        gPane.add(lblStudentId, 0, 0);
        gPane.add(txtStudentId, 1, 0);
        gPane.add(lblCourse, 0, 3);
        gPane.add(lblCourse1, 0, 4);
        gPane.add(txtCourse1, 1, 4);
        gPane.add(lblCourse2, 0, 5);
        gPane.add(txtCourse2, 1, 5);
        gPane.add(lblCourse3, 0, 6);
        gPane.add(txtCourse3, 1, 6);
        gPane.add(lblCourse4, 0, 7);
        gPane.add(txtCourse4, 1, 7);
        gPane.add(lblCourse5, 0, 8);
        gPane.add(txtCourse5, 1, 8);

        BorderPane bPane = new BorderPane();
        HBox buttons = new HBox(10, btnAdd, btnDisplay);
        bPane.setCenter(gPane);
        bPane.setBottom(buttons);
        return bPane;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
