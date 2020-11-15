package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
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


/**
 * The controller extends the class Application and implements the interface Initializable.
 * The controller controls the elements from JavaFX and their behavior.
 */
public class Controller extends Application implements Initializable {

  private final InformationController informationController = new InformationController();

  @FXML
  private TextField textInput1;
  @FXML
  private TextField textInput2;
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

  /**
   * The start method loads all files relevant for JavaFX and then starts the JavaFX Stage to
   * display the GUI.
   *
   * @param primaryStage Stage, which should be started from JavaFX
   */
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

  /**
   * This method initializes the controller. It is been used to set up the CellValueFactory.
   *
   * @param location not used yet
   * @param resources not used yet
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
    gradeColumn.setCellValueFactory(new PropertyValueFactory<>("subjectGrade"));
  }

  /**
   * This help method updates the text of the result display.
   */
  private void updateResultText() {
    String newString = String.valueOf(informationController.information.getAverageGradeValue());
    resultText.setText(newString);
  }

  /**
   *
   */
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

  /**
   *
   */
  @FXML
  public void calcButtonEvent() {
    informationController.calcAverageOfList();
    Platform.runLater(this::updateResultText);
  }

  /**
   *
   */
  @FXML
  public void resetButtonEvent() {
    informationController.resetInformationOfList();
    tableView.getItems().clear();
    Platform.runLater(this::updateResultText);
  }

}
