package musicCode;

import jm.music.data.Score;
import jm.util.Play;

public class TrackPlayer {
  public static final void play(Track track) {
    final Score s = new Score("Test Track Score");
    s.add(track);
    Play.midi(s);
  }
}
