package musicCode;

import java.util.List;

import scales.Scale;

/**
 * Represents a musical key, with a base note, a scale of notes, and a set of
 * chords. Chords are represented as integer differences (e.g. {0, 2, 4} ) which
 * are added to a given note value to make a chord.
 *
 * @author noahpicard
 *
 */
public class Key {
  private final Scale scale;
  private final List<int[]> chords;

  public Key(int[] notesN, int baseNoteN, List<int[]> chordsN) {
    this.scale = new Scale(baseNoteN, notesN);
    this.chords = chordsN;
  }

  public Key(Scale sc, List<int[]> chordsN) {
    this.scale = sc;
    this.chords = chordsN;
  }

  public Scale getScale() {
    return scale;
  }

  public int[] getNotes() {
    return scale.getTones();
  }

  public int getBaseNote() {
    return scale.getBaseNote();
  }

  public List<int[]> getChords() {
    return chords;
  }
}
