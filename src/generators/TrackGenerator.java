package generators;

import musicCode.Track;
import jm.JMC;

/**
 * Interface for a generator that produces a Track object.
 *
 * @author raphaelkargon
 *
 */
public interface TrackGenerator extends JMC {
  public Track generate(Track track);
}
