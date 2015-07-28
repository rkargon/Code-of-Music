package musicCode;

import java.util.List;

/**
 * Represents a musical key, with a base note, a scale of notes, and a set of
 * chords. Chords are represented as integer differences (e.g. {0, 2, 4} ) which
 * are added to a given note value to make a chord.
 *
 * @author noahpicard
 *
 */
public class Key {
  private final List<Integer> notes;
  private final int baseNote;
  private final List<Integer[]> chords;

  public Key(List<Integer> notesN, int baseNoteN, List<Integer[]> chordsN) {
    this.notes = notesN;
    this.baseNote = baseNoteN;
    this.chords = chordsN;
  }

  public List<Integer> getNotes() {
    return notes;
  }

  public int getBaseNote() {
    return baseNote;
  }

  public List<Integer[]> getChords() {
    return chords;
  }
}
