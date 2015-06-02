package musicCode;

import jm.music.data.Part;

/**
 * A single track in a music score. Extends jMusic's Part class, but adds a
 * generator that provides new notes to the part.
 *
 * @author raphaelkargon
 *
 */
public class Track extends Part {
  public Track(String title, int instrument) {
    super(title, instrument);
  }
}
