package java.main;

public class Subject {
  private String fachName;
  private int fachNote;

  public Subject(String fachName, int fachNote) {
    this.fachName = fachName;
    this.fachNote = fachNote;
  }

  public String getFachName() {
    return fachName;
  }

  public int getFachNote() {
    return fachNote;
  }

  public void setFachName(String fachName) {
    this.fachName = fachName;
  }

  public void setFachNote(int fachNote) {
    this.fachNote = fachNote;
  }
}
