package org.openjfx;

public class Subject {
  private String subjectName;
  private int subjectGrade;

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
  }

  public void setSubjectGrade(int subjectGrade) {
    this.subjectGrade = subjectGrade;
  }

}
