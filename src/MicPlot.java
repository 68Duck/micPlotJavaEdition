import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MicPlot {
  private Scene[] scenes;
  private final int numberOfMics;

  public MicPlot(int numberOfMics, int numberOfScenes){
    this.scenes = new Scene[numberOfScenes];
    this.numberOfMics = numberOfMics;
    this.setEmptyScenes();
  }

  private void setEmptyScenes(){
    for (int i = 0; i < this.scenes.length; i++){
      Scene newScene = new Scene(this.numberOfMics);
      this.scenes[i] = newScene;
    }
  }

  // Scenes are zero indexed;
  public void setScene(Scene scene, int sceneNumber) {
    assert scene.getNumberOfMics() == this.numberOfMics;
    this.scenes[sceneNumber] = scene;
  }

  public int getMicNumber(Person person, int sceneNumber){
    for (int i = 0; i < numberOfMics; i++){

      if (this.scenes[sceneNumber].getMic(i) == person){
        return i;
      }
    }
    throw new NullPointerException("That person is not yet in that scene");
  }

  //Check which people can be put into the current scene without swapping any mics
  //Returns the person with the mic that does not require a swap before that scene
  //The first Integer is the mic number, and the second is the scene number
  public List<Triplet<Person, Integer, Integer>> getFreeSwaps(int sceneNumber){
    List<Triplet<Person, Integer, Integer>> freeSwaps = new ArrayList<>();
    for (int j = 0; j < numberOfMics; j++){
      for (int i = sceneNumber; i >= 0; i--){
        if (!Objects.isNull(this.scenes[i].getMic(j))){
          freeSwaps.add(new Triplet<>(this.scenes[i].getMic((j)), j, i));
          break;
        }
      }
    }
    return freeSwaps;
  }


  public void setMic(int micNumber, int sceneNumber, Person person){
    this.scenes[sceneNumber].setMic(micNumber, person);
  }

  public Person getMic(int micNumber, int sceneNumber){
    return this.scenes[sceneNumber].getMic(micNumber);
  }

  public Scene getScene(int sceneNumber){
    return this.scenes[sceneNumber];
  }

  @Override
  public String toString() {
    StringBuilder returningString = new StringBuilder();
    int counter = 0;
    for (Scene scene: scenes){
      counter += 1;
      returningString.append("Scene ").append(counter).append("\n");
      returningString.append(scene);
    }
    return returningString.toString();
  }
}
