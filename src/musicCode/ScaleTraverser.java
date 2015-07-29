package musicCode;

import scales.Scale;

/**
 * A class for traversing a musical scale. The class keeps track of the tone
 * index and octave of the current note, which can be shifted up and down the
 * scale.
 *
 * @author raphaelkargon
 *
 */
public class ScaleTraverser {
  private Scale sc;
  private int currentIndex;
  private int currentOctave;

  public ScaleTraverser(Scale s, int initialNote) {
    this.sc = s;

    this.currentOctave = (initialNote - sc.getBaseNote()) / 12;
    int currentDiff = (initialNote - sc.getBaseNote()) % 12;
    this.currentIndex =
        Util.indexOf(sc.getBaseNote() + currentDiff, sc.getTones());
  }


  /**
   * Moves the current note up and down the scale, by indexChange notes.
   *
   * @param indexChange The number of notes to move up the scale (can be
   *        negative)
   */
  public void moveNote(int indexChange) {
    this.currentIndex += indexChange;
    currentOctave += Util.floorDiv(currentIndex, sc.getTones().length);
    this.currentIndex = Util.floorMod(currentIndex, sc.getTones().length);
  }

  /**
   * Returns the note shifted up or down the scale, without modifying the state
   * of the scaleTraverser.
   *
   * @param indexChange
   * @return
   */
  public int getShiftedNote(int indexChange) {
    int newIndex = currentIndex + indexChange;
    int newOctave =
        currentOctave + Util.floorDiv(newIndex, sc.getTones().length);
    newIndex = Util.floorMod(newIndex, sc.getTones().length);
    return sc.getNote(newIndex, newOctave);
  }

  /**
   * Creates a chord of notes, where note is shifted up the scale by degrees[i].
   *
   * @param degrees A list of the amounts to shift each note in the chord by.
   * @return A list of notes, consiting of the current note shifted up the scale
   *         by the values in 'degrees'
   */
  public int[] getChord(int[] degrees) {
    int[] outChord = new int[degrees.length];
    for (int i = 0; i < outChord.length; i++) {
      outChord[i] = getShiftedNote(degrees[i]);
    }
    return outChord;
  }

  /**
   * @return the numerical value of the current note.
   */
  public int getCurrentNote() {
    return sc.getNote(currentIndex, currentOctave);
  }

  /**
   * Returns the index, that corresponds to the tone of the note.
   *
   * @return the current index
   */
  public int getCurrentIndex() {
    return this.currentIndex;
  }

  /**
   * @return the current index
   */
  public int getCurrentOctave() {
    return this.currentOctave;
  }


}
