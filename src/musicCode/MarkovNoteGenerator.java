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
    if (currentNote.sameDuration(new Note(C4, QUARTER_NOTE, MEZZO_FORTE))) {
      currentNote = new Note(C4, EIGHTH_NOTE, MEZZO_FORTE);
    } else {
      currentNote = new Note(C4, QUARTER_NOTE, MEZZO_FORTE);
    }
    final int pitch = currentNote.getPitch();
    final int newpitch = Util.clamp(pitch + (int) (Math.random() * 5) - 2,
        CN1, G9);
    final Note newNote = currentNote.copy();
    newNote.setPitch(newpitch);
    currentNote = newNote;
    return newNote.copy();
  }
}
