package scales;

/**
 * Created by gildekel on 4/11/15.
 */
public abstract class PentatonicScale {
    private int[] tones;
    private int key;
    private String mood;

    public PentatonicScale(int[] tones, String mood, int key) {
        this.tones = tones;
        this.mood = mood;
        this.key = key;
    }

    public int[] getTones() {
        return tones;
    }

    public String getMood() {
        return mood;
    }

    public int getKey() {
        return key;
    }
}
