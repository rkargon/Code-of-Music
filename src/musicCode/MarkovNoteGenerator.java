package musicCode;

import jm.JMC;
import jm.music.data.Note;

public class MarkovNoteGenerator implements JMC {
  Note currentNote;

  // TODO params like tempo, key, amount of repetition, etc.
  public MarkovNoteGenerator() {
    currentNote = new Note(C4, QUARTER_NOTE, MEZZO_FORTE);
  }

  public Note nextNote() {
    int pitch = currentNote.getPitch();
    int newpitch = Util.clamp(pitch + (int) (Math.random() * 5) - 2, CN1, G9);
    Note newNote = currentNote.copy();
    newNote.setPitch(newpitch);
    currentNote = newNote;
    return newNote.copy();
  }
}
