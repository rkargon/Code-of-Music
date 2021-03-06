package generators;

import jm.music.data.Phrase;
import musicCode.Track;

public class ExampleTrackGenerator implements TrackGenerator {

  @Override
  public Track generate(Track trackN) {

    final Track track = trackN;
    final Phrase ph = new Phrase();
    track.add(ph);
    ph.setTempo(180);

    final MarkovGenerator gen = new MarkovGenerator();

    final int[] chord = { 59, 61, 64 };
    final int[] chord2 = { 56, 59, 64 };
    final int[] chord3 = { 52, 56, 61 };
    final int[] chord4 = { 61, 64, 68 };
    ph.addChord(chord, 2.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord2, 2.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord3, 1.0);
    ph.addChord(chord3, 3.0);
    ph.addChord(chord4, 2.0);
    ph.addChord(chord, 2.0);

    ph.addChord(chord, 2.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord2, 2.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord3, 1.0);
    ph.addChord(chord3, 3.0);
    ph.addChord(chord4, 2.0);
    ph.addChord(chord, 2.0);

    ph.addChord(chord, 2.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord4, 2.0);
    ph.addChord(chord4, 1.0);
    ph.addChord(chord4, 1.0);
    ph.addChord(chord3, 1.0);
    ph.addChord(chord3, 3.0);
    ph.addChord(chord2, 2.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord2, 1.0);

    ph.addChord(chord, 2.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord, 1.0);
    ph.addChord(chord2, 2.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord3, 1.0);
    ph.addChord(chord3, 2.0);
    ph.addChord(chord3, 1.0);
    ph.addChord(chord2, 2.0);
    ph.addChord(chord2, 1.0);
    ph.addChord(chord2, 1.0);

    return track;
  }

}
