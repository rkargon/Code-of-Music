package builders;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gildekel on 4/12/15.
 */
public class BarBuilder {

    private Random rnd = new Random();
    private ArrayList<Note> nextBar;
    private int tempo;
    private int nextNote;
    private PianoBuilder piano;

    public BarBuilder(int tempo, PianoBuilder piano, int lastNotePlayed) {

        this.tempo = tempo;
        this.piano = piano;
        nextNote = lastNotePlayed;
        nextBar = new ArrayList<Note>();

        int wholeNote = tempo;
        int halfNote = tempo / 2;
        int quarterNote = tempo / 4;
        int eightNote = tempo / 8;

        Random rnd = new Random();
        boolean noteUsed = true;

        while(tempo > 0)
        {
            if(noteUsed) {
                int direction = rnd.nextDouble() > 0.70 ? -1 : 1;
                int pitchChange = (rnd.nextInt(rnd.nextInt(2) + 2) + 1) * direction;

                if (nextNote + pitchChange >= 0 && nextNote + pitchChange < piano.getPiano().size()) {
                    nextNote = nextNote + pitchChange;
                } else {
                    continue;
                }
            }


            Double nextTempo = rnd.nextDouble();

                if (nextTempo < 0.2) {
                    if (tempo - wholeNote >= 0) {
                        tempo -= wholeNote;
                        nextBar.add(new Note(nextNote, wholeNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }


                else if (nextTempo < 0.4) {
                    if (tempo - halfNote >= 0) {
                        tempo -= halfNote;
                        nextBar.add(new Note(nextNote, halfNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else if (nextTempo < 0.6) {
                    if (tempo - quarterNote >= 0) {
                        tempo -= quarterNote;
                        nextBar.add(new Note(nextNote, quarterNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else if (nextTempo < 0.8) {
                    if (tempo - eightNote >= 0) {
                        tempo -= eightNote;
                        nextBar.add(new Note(nextNote, eightNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else if (nextTempo < 0.85) {
                    //QuarterNote Silence
                    if (tempo - quarterNote >= 0) {
                        tempo -= quarterNote;
                        nextBar.add(new Note(-1, quarterNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else if (nextTempo < 0.9) {
                    //HalfNote silence
                    if (tempo - halfNote >= 0) {
                        tempo -= halfNote;
                        nextBar.add(new Note(-1, halfNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else if (nextTempo < 0.95) {
                    //WholeNote silence
                    if (tempo - wholeNote >= 0) {
                        tempo -= wholeNote;
                        nextBar.add(new Note(-1, wholeNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
                }

                else {
                    //EightNote Silence
                    if(tempo-eightNote >= 0) {
                        tempo -= eightNote;
                        nextBar.add(new Note(-1, eightNote));
                        noteUsed = true;
                    } else {
                        noteUsed = false;
                    }
            }


        }
    }

    public ArrayList<Note> getNextBar() {
        return nextBar;
    }

}