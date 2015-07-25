package scales;

public class MajorPentatonic extends PentatonicScale {

  public MajorPentatonic(int key) {
    super(key, new int[] {key, key + 2, key + 4, key + 7, key + 9});
  }

}
