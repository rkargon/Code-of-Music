package musicCode;

import jm.JMC;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class Main implements JMC {
  public static void main(String[] args) {
    Score s = new Score("Test Score");
    Part p = new Part(PIANO);
    s.add(p);
    Phrase ph = new Phrase();
    p.add(ph);

    MarkovNoteGenerator gen = new MarkovNoteGenerator();
    for (int i = 0; i < 100; i++) {
      ph.add(gen.nextNote());
    }
    Play.midi(s);
  }
}
