package musicCode;

import generators.MarkovGenerator;
import generators.TrackGenerator;
import instruments.Piano;
import jm.JMC;

public class Main implements JMC {
  public static void main(String[] args) {

    Track track = new Track("Track1", new Piano());

    final TrackGenerator trackGen = new MarkovGenerator();

    track = trackGen.generate(track);

    TrackPlayer.play(track);
  }
}
