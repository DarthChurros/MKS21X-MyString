public class Driver {
  public static void main(String[] args) {
    String refStr = "antidisestablishmentarianism";
    MyString testStr = new MyString(refStr);
    int c = 0;
    if (testStr.length() != refStr.length()) {
      System.out.println(++c + ". length() is " + testStr.length() + " instead of " + refStr.length());
    }

    for (int i = -1; i <= testStr.length(); i++) {
      try {
        if (testStr.charAt(i) != refStr.charAt(i)) {
          System.out.println(++c + ". charAt() is returning the wrong char");
          break;
        }
        if (i < 0 || i >= testStr.length()) {
          System.out.println(++c + ". charAt(" + i + ") should throw an IndexOutOfBoundsException");
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(++c + ". charAt should not throw an ArrayIndexOutOfBoundsException");
      } catch (IndexOutOfBoundsException e) {
      }
    }
  }
}
