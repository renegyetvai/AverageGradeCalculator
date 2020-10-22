package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Application implements Initializable {

  private final InformationController informationController = new InformationController();

  @FXML
  private TextField textInput1;
  @FXML
  private TextField textInput2;
  /*@FXML
  private Button calcButton;
  @FXML
  private Button addButton;
  @FXML
  private Button resetButton;*/
  @FXML
  private Text resultText;
  @FXML
  private TableColumn<Subject, String> subjectColumn;
  @FXML
  private TableColumn<Subject, String> gradeColumn;
  @FXML
  private TableView<Subject> tableView;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("main.fxml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (NullPointerException ne) {
      System.err.println("An NullPointerException is occurred: " + ne.getMessage());
    }

    Scene scene = null;
    if (root != null) {
      scene = new Scene(root);
    }
    primaryStage.setMinHeight(350);
    primaryStage.setMinWidth(600);
    primaryStage.setTitle("Average-Grade-Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
    gradeColumn.setCellValueFactory(new PropertyValueFactory<>("subjectGrade"));
  }

  private void updateResultText() {
    String newString = String.valueOf(informationController.information.getAverageGradeValue());
    resultText.setText(newString);
  }

  @FXML
  public void addButtonEvent() {
    try {
      String name = textInput1.getText();
      int grade = Integer.parseInt(textInput2.getText());
      if (name != null && !name.equals("")) {
        informationController.addInformationToList(textInput1.getText(), grade);
        textInput1.clear();
        textInput2.clear();

        tableView.getItems().add(informationController.information.getLastSubject());

      } else {
        System.err.println("Incorrect input!");
      }
    } catch (NumberFormatException e) {
      System.err.println("Incorrect input: " + e.getMessage());
      //TODO: Popup bei falscher Eingabe implementieren
    }
  }

  @FXML
  public void calcButtonEvent() {
    informationController.calcAverageOfList();
    Platform.runLater(this::updateResultText);
  }

  @FXML
  public void resetButtonEvent() {
    informationController.resetInformationOfList();
    tableView.getItems().clear();
    Platform.runLater(this::updateResultText);
  }

}
