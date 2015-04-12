package scales;

/**
 * Created by gildekel on 4/11/15.
 */
public class MinorPentatonic extends PentatonicScale{

    public MinorPentatonic(int key) {
        super(new int[] {key, key+3, key+5, key+7, key+10}, "Happy", key);
    }
}
