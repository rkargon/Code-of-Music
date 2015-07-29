package generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jm.music.data.Phrase;
import musicCode.Key;
import musicCode.ScaleTraverser;
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
    ScaleTraverser scaleTraverser =
        new ScaleTraverser(key.getScale(), key.getBaseNote());

    for (int i = 0; i < 2000; i++) {
      int indexChange = (int) (Math.random() * 5) - 2;
      scaleTraverser.moveNote(indexChange);

      List<int[]> chords = key.getChords();
      int[] relChord = chords.get((int) (Math.random() * chords.size()));
      final int[] outChord = scaleTraverser.getChord(relChord);

      // TODO fix bounds issue
      if (outChord[0] < 0 || outChord[0] >= 127 - 12) {
        break;
      }
    }
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
    final List<int[]> chords = getChords();
    return new Key(sc, chords);
  }

  public List<int[]> getChords() {
    final List<int[]> chords = new ArrayList<>();

    final int[] major = {0, 2, 4};
    final int[] major5 = {0, 2};
    final int[] power = {0, 4};
    final int[] sus = {0, 3, 4};
    final int[] sus2 = {0, 1, 4};
    final int[] sixth = {0, 2, 4, 5};
    final int[] sixth5 = {0, 2, 5};
    final int[] sixth9 = {0, 2, 5, 8};
    final int[] seventh = {0, 2, 4, 6};
    final int[] seventh5 = {0, 2, 6};

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
