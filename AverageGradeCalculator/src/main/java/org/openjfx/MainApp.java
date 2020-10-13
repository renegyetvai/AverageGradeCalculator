package org.openjfx;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

  //object variables
  private int averageGradeValue;

  //list with all added subjects
  ObservableList<Subject> subjects = FXCollections.observableArrayList();

  //components for the JavaFX window
  private final BorderPane border = new BorderPane();
  private final HBox hBoxLeft1 = new HBox(10);
  private final HBox hBoxRight1 = new HBox(10);
  private final VBox vBoxLeft1 = new VBox(10);
  private final VBox vBoxLeft2 = new VBox(10);
  private final VBox vBoxLeft3 = new VBox(10);

  //components for the results table
  private StringProperty subjectName;
  private StringProperty grade;

  /**
   * method to calculate the average grade of all subjects
   *
   * @param list a list that provides subjects with subject names and grades
   * @return returns the average grade of all subjects inside the list
   */
  public int calcAverageGrade(ObservableList<Subject> list) {
    int cnt = 0;
    int sum = 0;
    for (Subject s : subjects) {
      sum+=s.getSubjectGrade();
      cnt++;
    }
    return sum / cnt;
  }

  /**
   * sets up the arrangement of the JavaFX GUI components for use by a user
   *
   * @param primaryStage primary stage for the JavaFX window
   * @throws Exception TODO: will be implemented soon
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    //components for IO
    TextField textInput1 = new TextField();
    textInput1.setPromptText("enter a grade");
    TextField textInput2 = new TextField();
    textInput2.setPromptText("enter the associated subject");
    Button addButton = new Button("add");
    Button calcAvgButton = new Button("calculate");

    //event-handler for buttons
    addButton.setOnAction(ActionEvent -> {
      if (textInput1.getText() != null && textInput2.getText() != null) {
        subjects.add(new Subject(textInput2.getText(), Integer.getInteger(textInput1.getText())));
      } else {
        System.err.println("incorrect input!");
      }
    });

    calcAvgButton.setOnAction(ActionEvent -> {
      if (!subjects.isEmpty()) {
        averageGradeValue = calcAverageGrade(subjects);
      } else {
        System.err.println("Error while calculating the result!");
      }
    });

    border.setLeft();
    border.setCenter();


    //making stage visible
    primaryStage.setTitle("Average-Grade-Calculator");
    primaryStage.setScene(new Scene(border, 900,600));
    primaryStage.show();
  }

  /**
   * starts the application
   * @param args not used by now
   */
  public static void main(String[] args) {
    launch();
  }
}

