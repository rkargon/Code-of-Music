package instruments;

import jm.JMC;
import jm.constants.Pitches;

public class Piano implements Instrument, JMC {

  @Override
  public int getInstrumentID() {
    return ELECTRIC_PIANO;
  }

  @Override
  public int getMinPitch() {
    // TODO Auto-generated method stub
    return Pitches.A0;
  }

  @Override
  public int getMaxPitch() {
    // TODO Auto-generated method stub
    return Pitches.C8;
  }

}
