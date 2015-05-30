package musicCode;

import static jm.constants.Durations.EN;
import static jm.constants.Durations.QN;
import static jm.constants.Pitches.C3;
import static jm.constants.Pitches.C4;
import static jm.constants.Scales.MAJOR_SCALE;
import static jm.constants.Volumes.PP;
import jm.music.data.Note;
import jm.util.Play;

public class Main {
  public static void main(String[] args) {
    Play.midi(new Note(C4, QN, PP));
    Play.midi(new Note(C3, EN));

    final int m = (int) (Math.random() * 86 + 20);
    while (true) {
      final Note n = new Note((int) (Math.random() * 86 + 20), QN);
      if (n.isScale(MAJOR_SCALE) == false) {
        continue;
      }
      Play.midi(n);
    }
  }

}
