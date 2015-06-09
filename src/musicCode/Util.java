package musicCode;

import jm.music.data.Note;

/**
 * Utility functions.
 *
 * @author raphaelkargon
 *
 */
public class Util {
  public static double clamp(double v, double min, double max) {
    return Math.max(Math.min(v, max), min);
  }

  public static int clamp(int v, int min, int max) {
    return Math.max(Math.min(v, max), min);
  }

  public static String printNote(Note note) {
    return note.toString();
  }
}
