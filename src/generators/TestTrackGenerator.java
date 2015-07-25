package generators;

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Phrase;
import musicCode.Track;

public class TestTrackGenerator implements TrackGenerator {

  @Override
  public Track generate(Track trackN) {

    final Track track = trackN;
    final Phrase ph = new Phrase();
    track.add(ph);
    ph.setTempo(140);

    final Key key = getKey();

    int baseNote = 0;
    int baseOctave = 0;

    final int notesInOctave = 7;
    final int octaveCount = 12;

    for (int i = 0; i < 20000; i++) {
      final int newValue = baseNote + baseOctave * notesInOctave
          + (int) (Math.random() * 4) - 2 + (int) (Math.random() * 4) - 2;
      baseNote = (newValue + notesInOctave) % notesInOctave;
      baseOctave = newValue / notesInOctave;

      System.out.println("Next:" + baseNote);
      System.out.println(baseOctave);

      final List<Integer[]> chords = key.getChords();
      final Integer[] relChord = chords.get((int) (Math.random() * (chords
          .size() - 1)));

      System.out.println(relChord);

      final List<Integer> chord = new ArrayList<>();
      for (final int relNote : relChord) {

        int varNote = baseNote + relNote;
        final int varOctave = varNote / notesInOctave;
        varNote = varNote % notesInOctave;

        chord.add(key.getNotes().get(varNote) + (baseOctave + varOctave)
            * octaveCount);
      }

      System.out.println(chord);

      ph.addChord(toIntArray(chord), Math.random() * 0.1 + 1.95);
    }

    /*
     * final int[] chordB1 = { c3, e3, g3 }; final int[] chordB2 = { d3, f3, a3
     * }; final int[] chordB3 = { d3, b2, g2 }; final int[] chordB4 = { c3, a2,
     * f2 };
     *
     * for (int i = 0; i < 8; i++) {
     *
     * ph.addChord(chordB1, 2.0); ph.addChord(chordB2, 2.0);
     * ph.addChord(chordB3, 2.0); ph.addChord(chordB4, 2.0);
     *
     * }
     */

    return track;
  }

  int[] toIntArray(List<Integer> list) {
    final int[] ret = new int[list.size()];
    for (int i = 0; i < ret.length; i++)
      ret[i] = list.get(i);
    return ret;
  }

  public Key getKey() {
    final int baseNote = (int) (Math.random() * 11) + 48;
    System.out.println(baseNote);

    final int[] notePattern = { 0, 2, 4, 5, 7, 9, 11 };
    final List<Integer> notes = new ArrayList<>();
    for (final int note : notePattern) {
      notes.add(baseNote + note);
    }
    System.out.println(notes);

    final List<Integer[]> chords = getChords();
    System.out.println(chords);

    return new Key(notes, baseNote, chords);
  }

  public List<Integer[]> getChords() {
    final List<Integer[]> chords = new ArrayList<>();

    final Integer[] major = { 0, 2, 4 };
    final Integer[] minor = { 0, 1, 4 };
    final Integer[] other = { 0, 3, 5 };

    chords.add(major);
    chords.add(minor);
    // chords.add(other);

    return chords;
  }

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

}
