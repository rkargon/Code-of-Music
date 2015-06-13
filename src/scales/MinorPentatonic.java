package scales;

public class MinorPentatonic extends PentatonicScale {

  public MinorPentatonic(int key) {
    super(key, new int[] {key, key + 3, key + 5, key + 7, key + 10});
  }

}
