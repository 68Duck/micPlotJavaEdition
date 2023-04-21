public class Triplet<S,T,U> {
  S first;
  T second;
  U third;
  public Triplet(S first, T second, U third){
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public S getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public U getThird() {
    return third;
  }

  @Override
  public String toString() {
    return first.toString() + "," +  second.toString() + "," + third.toString();
  }
}
