package musicCode;

import jm.JMC;
import jm.music.data.Note;

public class MarkovNoteGenerator implements JMC {
  Note currentNote;

  // TODO params like tempo, amount of repetition, etc.
  public MarkovNoteGenerator() {
    currentNote = new Note(C4, QN);
  }

  public Note nextNote() {
    int pitch = currentNote.getPitch();
    int newpitch = Util.clamp(pitch + (int) (Math.random() * 5) - 2, CN1, G9);
    Note newNote = new Note(newpitch, QN);
    currentNote = newNote;
    return newNote.copy();
  }
}
