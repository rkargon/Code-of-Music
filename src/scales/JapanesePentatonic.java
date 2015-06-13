package scales;

public class JapanesePentatonic extends PentatonicScale {

  public JapanesePentatonic(int key) {
    super(key, new int[] {key, key + 2, key + 3, key + 7, key + 8});
  }
}
