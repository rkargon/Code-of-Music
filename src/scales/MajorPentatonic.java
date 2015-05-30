package scales;

/**
 * Created by gildekel on 4/12/15.
 */
public class MajorPentatonic extends PentatonicScale {

    public MajorPentatonic(int key) {
        super(new int[]{key, key + 2, key + 4, key + 7, key + 9}, "Happy", key);
    }
}


