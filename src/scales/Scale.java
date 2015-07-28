package scales;

public class Scale {
  protected int baseNote;
  protected int tones[];

  public Scale(int baseNote, int[] degrees) {
    super();
    this.baseNote = baseNote;
    this.tones = new int[degrees.length];
    for (int i = 0; i < degrees.length; i++) {
      tones[i] = baseNote + degrees[i];
    }
  }

  /**
   * @return the base note
   */
  public int baseNote() {
    return baseNote;
  }

  /**
   * @return the tones
   */
  public int[] getTones() {
    return tones.clone();
  }

}
