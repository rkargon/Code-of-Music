package scales;

import musicCode.Util;

/**
 * Represents a set of notes, with a base note and tones related to that note.
 *
 * @author raphaelkargon
 *
 */
public class Scale {
  protected int baseNote;
  protected int tones[];

  /**
   * Creates a scale, with a base note and a set of integers, representing
   * shifts up from the original note. For instance, Scale(60, {1, 2, 3}) would
   * create a scale consisting of the notes {60, 61, 62, 63}
   *
   * @param baseNote
   * @param degrees
   */
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
  public int getBaseNote() {
    return baseNote;
  }

  /**
   * @return the tones
   */
  public int[] getTones() {
    return tones.clone();
  }

  /**
   * Get the numerical note, with an index corresponding to a tone, and an
   * octave number.
   *
   * @param index The index of the tone the note is one.
   * @param octave The number of octaves the note is shiftd from the scale's
   *        base note.
   * @return The numerical value of the note.
   */
  public int getNote(int index, int octave) {
    return tones[index] + octave * 12;
  }

}
