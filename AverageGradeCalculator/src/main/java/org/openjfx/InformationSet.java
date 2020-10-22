package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InformationSet {

  //object variables
  private int averageGradeValue;

  //list with all added subjects
  private final ObservableList<Subject> subjects = FXCollections.observableArrayList();

  public void setAverageGradeValue() {
    if (subjects.size() > 0) {
      averageGradeValue = calcAverageGrade(subjects);
    } else {
      averageGradeValue = 0;
    }
  }

  public int getAverageGradeValue() {
    return averageGradeValue;
  }

  public Subject getLastSubject() {
    return subjects.get(subjects.size() - 1);
  }

  public void addSubject(String subjectName, int grade) {
    subjects.add(new Subject(subjectName, grade));
  }

  public boolean subjectsIsEmpty() {
    return subjects.isEmpty();
  }

  public void resetSubjects() {
    subjects.clear();
    setAverageGradeValue();
  }

  /**
   * method to calculate the average grade of all subjects
   *
   * @param list a list that provides subjects with subject names and grades
   * @return returns the average grade of all subjects inside the list
   */
  public int calcAverageGrade(ObservableList<Subject> list) {
    int cnt = 0;
    int sum = 0;
    for (Subject s : list) {
      sum += s.getSubjectGrade();
      cnt++;
    }
    return sum / cnt;
  }

}
