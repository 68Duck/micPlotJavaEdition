public class Main {
  public static void main(String[] args) {
    Person a = new Person("A", 1);
    Person b = new Person("B", 2);
    Person c = new Person("C", 3);
    Person d = new Person("D", 4);
    Person e = new Person("E", 5);

    Person[][] people2 = {{a, b, c}, {a, d}, {d, e}, {b, c, d}};
    PeopleInScenes testPeopleInScenes = new PeopleInScenes(people2);
    Solver solver = new Solver(testPeopleInScenes, 3);
    solver.solve();
    System.out.println(solver.getMicPlot());
  }

  public static void test(){
    Person person1 = new Person("Josh", 1);

    Scene newScene = new Scene(5);

    newScene.setMic(1, person1);

    MicPlot micPlot = new MicPlot(5, 2);
    micPlot.setScene(newScene, 0);
    System.out.println(micPlot);
  }
}