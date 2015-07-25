package musicCode;

import jm.music.data.Phrase;

public class CalifornicationTrackGenerator extends TrackGenerator {

  @Override
  public Track generate(Track trackN) {

    final Track track = trackN;
    final Phrase ph = new Phrase();
    track.add(ph);
    ph.setTempo(140);

    // AEBC...bcba, FCGA. DC

    final int[] chord = {};
    final int[] chordA = { a2 };
    final int[] chordE = { e3 };
    final int[] chordB = { b3 };
    final int[] chordCH = { c4 };

    final int[] chordF = { f2 };
    final int[] chordC = { c3 };
    final int[] chordG = { g3 };
    final int[] chordAH = { a3 };
    final int[] chordD = { d3 };

    for (int i = 0; i < 8; i++) {

      ph.addChord(chordA, 1.0);
      ph.addChord(chordE, 1.0);
      ph.addChord(chordB, 1.0);
      ph.addChord(chordCH, 2.5);
      ph.addChord(chordB, 0.5);
      ph.addChord(chordCH, 0.5);
      ph.addChord(chordB, 0.5);
      ph.addChord(chordAH, 1.0);

      ph.addChord(chordF, 1.0);
      ph.addChord(chordC, 1.0);
      ph.addChord(chordG, 1.0);
      ph.addChord(chordAH, 2.0);
      ph.addChord(chordD, 1.0);
      ph.addChord(chordC, 2.0);

    }

    return track;
  }

}
