package musicCode;

import instruments.Instrument;
import jm.music.data.Part;
import jm.music.data.Phrase;

/**
 * A single track in a music score. Contains an instrument, a jMusic Part to
 * store notes, and a generator.
 *
 * @author raphaelkargon
 *
 */
public class Track {
  private final Part part;
  private Instrument instrument;

  public Track(String title, Instrument instrument) {
    this.part = new Part(title, instrument.getInstrumentID());
  }

  public void add(Phrase phrase) {
    part.add(phrase);
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
