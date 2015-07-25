package instruments;

/**
 * Represents a musical instrument, with a corresponding MIDI program ID
 *
 * TODO provide ability to restrict to certain scales. Maybe use a getNote()
 * method here, that accepts args that restrict the possible notes?
 *
 * @author raphaelkargon
 *
 */
public interface Instrument {
  /**
   * @return the instrument's MIDMI program id
   */
  public int getInstrumentID();

  /**
   * @return the lowest note this instrument can play
   */
  public int getMinPitch();

  /**
   * @return the highest note this instrument can play
   */
  public int getMaxPitch();
}
