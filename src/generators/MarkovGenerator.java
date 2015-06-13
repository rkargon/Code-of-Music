package generators;

import instruments.Piano;
import jm.music.data.Note;
import jm.music.data.Part;
import musicCode.Track;
import musicCode.Util;

/**
 * Generates a series of notes through a markov chain. i.e. Keeps track of the
 * current note, and the next note is shifted a small, random amount up or down
 * from the current one.
 *
 * TODO add paramaters like tempo, key, amount of repetition, etc
 *
 * TODO vary note duration
 *
 * TODO keep track of bars, make sure note durations in each bar add up properly
 *
 * @author raphaelkargon
 *
 */
public class MarkovGenerator implements TrackGenerator {
  private Note currentNote;

  public MarkovGenerator() {
    currentNote = new Note(C4, QUARTER_NOTE, MEZZO_FORTE);
  }

  public Note nextNote() {
    final int pitch = currentNote.getPitch();
    final int newpitch =
        Util.clamp(pitch + (int) (Math.random() * 5) - 2, CN1, G9);
    final Note newNote = currentNote.copy();
    newNote.setPitch(newpitch);
    currentNote = newNote;
    return newNote.copy();
  }

  @Override
  public Track generate(Track track) {
    Track t = new Track("Markov Track", new Piano());
    Part p = t.getMusic();
    for (int i = 1; i <= 50; i++) {
      p.addNote(nextNote(), i);
    }
    return t;
  }
}
