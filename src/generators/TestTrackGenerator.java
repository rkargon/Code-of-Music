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

    int lowestNote = 100;
    for (int i = 0; i < 20000; i++) {

      final int newValue = baseNote + baseOctave * notesInOctave
          + randomRange(-2, 1) + randomRange(-2, 1);
      lowestNote = Math.min(lowestNote, newValue);

      baseNote = (newValue + notesInOctave) % notesInOctave;
      baseOctave = newValue / notesInOctave;

      System.out.println("Next:" + baseNote);
      System.out.println(baseOctave);

      final List<Integer[]> chords = key.getChords();

      final Integer[] relChord = chords.get((int) (Math.random() * chords
          .size()));

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

      printTonic(key.getBaseNote());
      System.out.println(c3);

      ph.addChord(toIntArray(chord), Math.random() * 0.1 + 1.95);
    }

    System.out.println(lowestNote);

    return track;
  }

  public int randomRange(int min, int max) {
    final int range = max - min + 1;
    return (int) (Math.random() * range) + min;
  }

  public void printTonic(int n) {
    System.out.println(((Integer) n).toString() + " = "
        + (char) ((n - 46) % 7 + 65));
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
    // final int[] notePattern = { 0, 2, 3, 5, 7, 8, 10 };
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
    final Integer[] major5 = { 0, 2 };
    final Integer[] power = { 0, 4 };
    final Integer[] sus = { 0, 3, 4 };
    final Integer[] sus2 = { 0, 1, 4 };
    final Integer[] sixth = { 0, 2, 4, 5 };
    final Integer[] sixth5 = { 0, 2, 5 };
    final Integer[] sixth9 = { 0, 2, 5, 8 };
    final Integer[] seventh = { 0, 2, 4, 6 };
    final Integer[] seventh5 = { 0, 2, 6 };

    chords.add(major);
    chords.add(major5);
    chords.add(power);
    chords.add(sus);
    chords.add(sus2);
    chords.add(sixth);
    chords.add(sixth5);
    chords.add(sixth9);
    chords.add(seventh);
    chords.add(seventh5);

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
