package scales;

/**
 * Created by gildekel on 4/12/15.
 */
public class JapanesePentatonic extends PentatonicScale{
    public JapanesePentatonic(int key) {
        super(new int[]{key, key + 2, key + 3, key + 7, key + 8}, "Happy", key);
    }
}
