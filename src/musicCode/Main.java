package musicCode;

import jm.JMC;

public class Main implements JMC {
  public static void main(String[] args) {

    Track track = new Track("Track1", ELECTRIC_PIANO);

    final TrackGenerator trackGen = new TestTrackGenerator();

    track = trackGen.generate(track);

    TrackPlayer.play(track);
  }
}
