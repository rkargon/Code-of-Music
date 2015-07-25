package musicCode;

import jm.music.data.Score;
import jm.util.Play;

/**
 * Class for playing a track
 *
 * @author raphaelkargon
 *
 */
public class TrackPlayer {
  public static final void play(Track track) {
    final Score s = new Score("Test Track Score");
    s.add(track.getMusic());
    Play.midi(s);
  }
}
