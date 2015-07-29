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

  /**
   * An integer array version of the List indexOf(). Returns the index of the
   * element that equals the given integer
   *
   * @param n The number to search for
   * @param array The array to search in
   * @return The index of n in array, or -1 if n is not in array.
   */
  public static int indexOf(int n, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (n == array[i]) {
        return i;
      }
    }
    return -1;
  }

  /* floorDiv and floorMod are only available in Java 8 :-( */

  /**
   * Integer division that rounds down, instead of to 0
   *
   * (copied from openjdk 8)
   *
   * @param divisor
   * @param dividend
   * @return divisor/dividend, floored instead of rounded to zero
   */
  public static int floorDiv(int x, int y) {
    int r = x / y;
    // if the signs are different and modulo not zero, round down
    if ((x ^ y) < 0 && (r * y != x)) {
      r--;
    }
    return r;
  }

  /**
   * Uses floorDiv instead of / operator for division, so rounds down towards
   * -inf instead of towards 0.
   *
   * @param x dividend
   * @param y divisor
   * @return x - floorDiv(x, y) * y;
   */
  public static int floorMod(int x, int y) {
    int r = x - floorDiv(x, y) * y;
    return r;
  }
}
