package musicCode;

import instruments.Instrument;
import jm.music.data.Part;

/**
 * A single track in a music score. Contains an instrument, a jMusic Part to
 * store notes, and a generator.
 *
 * @author raphaelkargon
 *
 */
public class Track {
  private Part part;
  private Instrument instrument;

  public Track(String title, Instrument instrument) {
    this.part = new Part(title, instrument.getInstrumentID());
  }

  /**
   * Returns the object containing the music date (notes) of this track.
   *
   * @return part
   */
  public Part getMusic() {
    return part;
  }
}
