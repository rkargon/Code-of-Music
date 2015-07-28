package generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jm.music.data.Phrase;
import musicCode.Key;
import musicCode.Track;
import scales.Scale;

public class MarkovGenerator implements TrackGenerator {

  @Override
  public Track generate(Track trackN) {
    final Track track = trackN;
    final Phrase ph = new Phrase();
    track.add(ph);
    ph.setTempo(140);

    final Key key = getKey();

    // int baseNote = 0;
    // int baseOctave = 0;
    // final int notesInOctave = 7;
    // final int octaveCount = 12;

    int currentOctave = 0, currentIndex = 0;
    for (int i = 0; i < 2000; i++) {
      // get index for base note of current chord, as well as the note's octave
      int indexChange =
          (int) (Math.random() * 5) - 2 + (int) (Math.random() * 5) - 2;
      currentIndex += indexChange;
      if (currentIndex < 0) {
        currentOctave--;
      } else if (currentIndex >= key.getNotes().length) {
        currentOctave++;
      }
      currentIndex =
          (currentIndex + key.getNotes().length) % key.getNotes().length;

      List<Integer[]> chords = key.getChords();
      Integer[] randChord = chords.get((int) (Math.random() * chords.size()));

      final int[] outChord = new int[randChord.length];
      for (int j = 0; j < outChord.length; j++) {
        int newIndex = currentIndex + randChord[j];
        int newOctave = currentOctave;
        if (newIndex < 0) {
          newOctave--;
        } else if (newIndex >= key.getNotes().length) {
          newOctave++;
        }
        newIndex = (newIndex + key.getNotes().length) % key.getNotes().length;
        int chordNote = key.getNotes()[newIndex] + newOctave * 12;
        outChord[j] = chordNote;
      }

      // random walk sometimes goes out of bounds, we need to fix this (and can
      // do so rather easily)
      boolean outOfBounds = false;
      for (int note : outChord) {
        if (note > 127 || note < 0) {
          outOfBounds = true;
          break;
        }
      }
      if (outOfBounds) {
        break;
      }
      ph.addChord(outChord, Math.random() * 0.1 + 1.95);
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

  public void printTonic(int n) {
    System.out.println(((Integer) n).toString() + " = "
        + (char) ((n - 46) % 7 + 65));
  }

  /**
   * Generates a key based on a random base note, a scale of notes, and a set of
   * chords.
   *
   * @return a Key
   */
  public Key getKey() {
    final int baseNote = (int) (Math.random() * 11) + 48;
    final int[] notePattern = {0, 2, 4, 5, 7, 9, 11};
    // final int[] notePattern = { 0, 2, 3, 5, 7, 8, 10 };
    Scale sc = new Scale(baseNote, notePattern);
    final List<Integer[]> chords = getChords();

    System.out.println(baseNote);
    System.out.println(Arrays.toString(sc.getTones()));
    System.out.println(chords);

    return new Key(sc, chords);
  }

  public List<Integer[]> getChords() {
    final List<Integer[]> chords = new ArrayList<>();

    final Integer[] major = {0, 2, 4};
    final Integer[] major5 = {0, 2};
    final Integer[] power = {0, 4};
    final Integer[] sus = {0, 3, 4};
    final Integer[] sus2 = {0, 1, 4};
    final Integer[] sixth = {0, 2, 4, 5};
    final Integer[] sixth5 = {0, 2, 5};
    final Integer[] sixth9 = {0, 2, 5, 8};
    final Integer[] seventh = {0, 2, 4, 6};
    final Integer[] seventh5 = {0, 2, 6};

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

}
