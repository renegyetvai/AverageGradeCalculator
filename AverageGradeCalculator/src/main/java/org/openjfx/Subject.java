package org.openjfx;

import javafx.beans.property.SimpleStringProperty;

public class Subject {
  private String subjectName;
  private int subjectGrade;
  /*private SimpleStringProperty subjectNameProperty;
  private SimpleStringProperty subjectGradeProperty;*/

  public Subject(String subjectName, int subjectGrade) {
    this.subjectName = subjectName;
    this.subjectGrade = subjectGrade;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public int getSubjectGrade() {
    return subjectGrade;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
    //subjectNameProperty = new SimpleStringProperty(subjectName);
  }

  public void setSubjectGrade(int subjectGrade) {
    this.subjectGrade = subjectGrade;
    //subjectGradeProperty = new SimpleStringProperty(String.valueOf(subjectGrade));
  }

}
