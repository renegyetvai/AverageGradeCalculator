package org.openjfx;

/**
 *
 */
public class Subject {
  private String subjectName;
  private int subjectGrade;

  public Subject(String subjectName, int subjectGrade) {
    this.subjectName = subjectName;
    this.subjectGrade = subjectGrade;
  }

  /**
   *
   * @return
   */
  public String getSubjectName() {
    return subjectName;
  }

  /**
   *
   * @return
   */
  public int getSubjectGrade() {
    return subjectGrade;
  }

  /**
   *
   * @param subjectName
   */
  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  /**
   *
   * @param subjectGrade
   */
  public void setSubjectGrade(int subjectGrade) {
    this.subjectGrade = subjectGrade;
  }
}
