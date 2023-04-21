import java.util.Objects;

public class Scene {

  private Person[] micAssignment;
  private int numberOfMics;

  public Scene(int numberOfMics){
    this.numberOfMics = numberOfMics;
    this.micAssignment = new Person[numberOfMics];
  }

  public int getNumberOfMics() {
    return numberOfMics;
  }

  public void setMic(int micNumber, Person person){
    this.micAssignment[micNumber] = person;
  }

  public Person getMic(int micNumber){
    return this.micAssignment[micNumber];
  }

  @Override
  public String toString() {
    StringBuilder returningString = new StringBuilder();
    int counter = 0;
    for (Person person: micAssignment){
      counter += 1;
      if (Objects.isNull(person)){
        returningString.append("Mic ").append(counter).append(": ").append("Free").append("\n");
      } else {
        returningString.append("Mic ").append(counter).append(": ").append(person).append("\n");
      }
    }
    return returningString.toString();
  }
}
