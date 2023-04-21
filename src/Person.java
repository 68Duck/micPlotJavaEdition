public class Person {
  private final String name;
  //Priority can be used as an id for each character/person
  private final int priority;

  public Person(String name, int priority){
    this.name = name;
    this.priority = priority;
  }

  @Override
  public String toString() {
    return this.name + "(" + this.priority + ")";
  }

  public String getName(){
    return this.name;
  }

  public int getPriority() {
    return priority;
  }
}
