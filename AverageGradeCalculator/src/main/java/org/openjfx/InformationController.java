package org.openjfx;

/**
 *
 */
public class InformationController {

  InformationSet information = new InformationSet();

  /**
   *
   */
  public void calcAverageOfList() {
    if (!information.subjectsIsEmpty()) {
      information.setAverageGradeValue();
    } else {
      System.err.println("List is empty!");
    }
  }

  /**
   *
   * @param name
   * @param grade
   */
  public void addInformationToList(String name, int grade) {
    information.addSubject(name, grade);
  }

  /**
   *
   */
  public void resetInformationOfList() {
    information.resetSubjects();
  }

}
