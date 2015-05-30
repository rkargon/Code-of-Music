package builders;

import scales.MajorPentatonic;
import scales.PentatonicScale;

import java.util.ArrayList;

/**
 * Created by gildekel on 4/12/15.
 */
public class PianoBuilder {

    private ArrayList<Integer> piano;
    private int lowestKey;

    public PianoBuilder(int key) {
        piano = new ArrayList<Integer>();
        lowestKey = key;

        while(lowestKey >= 36) {
            if(lowestKey-12 < 36)
                break;
            else
                lowestKey -= 12;
        }

        for(int i = lowestKey; i < 84; i += 12) {
            PentatonicScale currentScale = new MajorPentatonic(i);
            for(int j = 0; j < 5; j++) {
                piano.add(currentScale.getTones()[j]);
            }
        }
    }

    public ArrayList<Integer> getPiano() {
        return piano;
    }

    public int getLowestKey() { return lowestKey; }
}
