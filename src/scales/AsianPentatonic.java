package scales;

public class AsianPentatonic extends PentatonicScale {

  public AsianPentatonic(int key) {
    super(key, new int[] {key, key + 2, key + 5, key + 7, key + 9});
  }

}
