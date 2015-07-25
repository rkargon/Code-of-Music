package scales;

/**
 * Represents a scale of five notes. Notes are in descending or ascending order.
 *
 * @author raphaelkargon
 *
 */
public class PentatonicScale {
  private int key;
  private int tones[];

  /**
   * Creates a new Pentatonic Scale
   *
   * @param key
   * @param tones
   */
  public PentatonicScale(int key, int[] tones) {
    super();
    this.key = key;
    this.tones = tones;
    // Check proper number of tones
    if (tones.length != 5) {
      throw new IllegalArgumentException("Number of tones must be 5.");
    }
    // Check if tones are properly sorted
    if (tones.length > 1) {
      int diff1 = Integer.compare(tones[0], tones[1]);
      for (int i = 1; i < tones.length - 1; i++) {
        if (diff1 != Integer.compare(tones[i], tones[i + 1])) {
          throw new IllegalArgumentException(
              "Tones must all be in ascending or descending order.");
        }
      }
    }
  }

  /**
   * @return the key
   */
  public int getKey() {
    return key;
  }

  /**
   * @return the tones
   */
  public int[] getTones() {
    return tones.clone();
  }

}
