package musicCode;

import java.util.List;

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
