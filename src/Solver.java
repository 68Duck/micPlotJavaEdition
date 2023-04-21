import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {
  private MicPlot micPlot;
  private int numberOfMics;
  private final PeopleInScenes peopleInScenes;

  public Solver(PeopleInScenes peopleInScenes, int numberOfMics){
    this.peopleInScenes = peopleInScenes;
    this.numberOfMics = numberOfMics;
    this.micPlot = new MicPlot(numberOfMics, peopleInScenes.getNumberOfScenes());
  }


  public void solve(){
    for (int i = 0; i < peopleInScenes.getPeopleInScene(0).length; i++){
      this.micPlot.setMic(i, 0, peopleInScenes.getPeopleInScene(0)[i]);
    }
    Set<Person> pool = new HashSet<>();
    for (int i = 1; i < peopleInScenes.getNumberOfScenes(); i++){
      for (Person person: peopleInScenes.getPeopleInScene(i)){
        try {
          int micNumber = micPlot.getMicNumber(person, i-1);
          micPlot.setMic(micNumber, i, person);
        } catch (NullPointerException e) {
          //The person is not already in the scene
          pool.add(person);
          System.out.println(pool);
          if (pool.size() > this.numberOfMics){  //TODO: May need to change this to number of free slots in the scene with the minimum number of slots
            List<Triplet<Person, Integer, Integer>> freeSwaps = this.micPlot.getFreeSwaps(i);
            System.out.println(freeSwaps);

            for (Triplet<Person, Integer, Integer> freeSwap: freeSwaps){
              for (int j = freeSwap.getThird(); j < i; j++){
                if (peopleInScenes.personInScene(person, j)){
                  micPlot.setMic(freeSwap.getSecond(), i, freeSwap.getFirst());
                  pool.remove(freeSwap.getFirst());
                  break;
                }
              }
            }
          }
        }
      }
    }

  }

  public MicPlot getMicPlot(){
    return this.micPlot;
  }
}
