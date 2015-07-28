package musicCode;

import java.util.List;

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

  public static int[] toIntArray(List<Integer> list) {
    final int[] ret = new int[list.size()];
    for (int i = 0; i < ret.length; i++)
      ret[i] = list.get(i);
    return ret;
  }
}
