public class Pair<S, T> {
  S first;
  T second;
  public Pair(S first, T second){
    this.first = first;
    this.second = second;
  }

  public S getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }
}
