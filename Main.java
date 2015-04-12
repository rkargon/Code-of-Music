import builders.BarBuilder;
import builders.PianoBuilder;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import java.util.Random;


/**
 * Created by gildekel on 4/11/15.
 */
public class Main {

    static int KEY = 60;
    static int TEMPO = 1600;

    public static void main(String[] args)
    {
        Random rnd = new Random();
        int barsCount = 50;
        PianoBuilder piano = new PianoBuilder(KEY);
        BarBuilder nextBar = new BarBuilder(TEMPO, piano, piano.getPiano().indexOf(KEY));


        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();

            MidiChannel[] channels = synthesizer.getChannels();
            int nextPitch = 0;

            for(int i = 0; i < barsCount; i++) {
                System.out.println("Bar: " + (i+1));
                for(int j = 0; j < nextBar.getNextBar().size(); j++) {
                    //----PITCH----
                    nextPitch = nextBar.getNextBar().get(j).getPitch();
                    if(nextPitch > 0) {
                        channels[0].noteOn(piano.getPiano().get(nextPitch), 85);
                    } //else play nothing

                    channels[1].noteOn(piano.getLowestKey()+19, 65);
                    channels[2].noteOn(piano.getLowestKey() + 12, 65);

                    //----TEMPO----
                    Thread.sleep(nextBar.getNextBar().get(j).getDuration());


                    //----KILL NOTES----
                    channels[0].allNotesOff();
                }

                nextBar = new BarBuilder(TEMPO, piano, nextPitch);
            }


            Thread.sleep(1000);
            synthesizer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
