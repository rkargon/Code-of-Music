package musicCode;

import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

public class Main implements JMC {
  public static void main(String[] args) {
    final Score s = new Score("Test Score");
    final Part p = new Part(ELECTRIC_PIANO);
    s.add(p);
    final Phrase ph = new Phrase();
    final CPhrase pb = new CPhrase();
    p.add(ph);
    ph.setTempo(140);

    final MarkovNoteGenerator gen = new MarkovNoteGenerator();
    for (int i = 0; i < 10; i++) {
      ph.add(gen.nextNote());
    }

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

    Play.midi(s);
  }
}
