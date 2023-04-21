import java.util.Arrays;

public class PeopleInScenes {
  private final Person[][] peopleInScenes;

  public PeopleInScenes(Person[][] peopleInScenes){
    this.peopleInScenes = peopleInScenes;
  }

  public Person[] getPeopleInScene(int sceneNumber){
    return this.peopleInScenes[sceneNumber];
  }

  public boolean personInScene(Person person, int sceneNumber){
    //CHECK THAT THIS WORKS
    return Arrays.stream(this.peopleInScenes[sceneNumber]).map(x -> x == person).reduce(Boolean::logicalOr).orElse(false);
  }

  public int getNumberOfScenes(){
    return peopleInScenes.length;
  }

}
