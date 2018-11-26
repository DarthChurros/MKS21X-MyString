public class MyString implements
  CharSequence,
  Comparable<CharSequence>
{
  private char[] data;
  public MyString(CharSequence s) {
    data = new char[s.length()];
    for (int i = 0; i < data.length; i++) {
      data[i] = s.charAt(i);
    }
  }

  public int length() {
    return data.length;
  }

  public char charAt(int index) {
    try {
      return data[index];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Invalid index for charAt");
    }
  }

  public CharSequence subSequence(int start, int end) {
    String ans = "";
    for (int i = start; i < end; i++) {
      ans += charAt(i);
    }
    return ans;
  }

  public String toString() {
    return (String)subSequence(0,length());
  }

  public int compareTo(CharSequence other) {
    if (other == null) {
      throw new NullPointerException("Cannot compare to null");
    }
    for (int i = 0; i < Math.min(length(),other.length()); i++) {
      if (charAt(i) != other.charAt(i)) {
        return (charAt(i) - other.charAt(i));
      }
    }
    return length() - other.length();
  }

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
        System.out.println(++c + ". charAt() should not throw an ArrayIndexOutOfBoundsException");
      } catch (IndexOutOfBoundsException e) {
      }
    }

    if (!testStr.toString().equals(refStr)) {
      System.out.println(++c + ". testStr converts to " + testStr + " instead of " + refStr);
    }

    if (!testStr.subSequence(1,7).toString().equals(refStr.subSequence(1,7))) {
      System.out.println(++c + ". subSequence(1,7) is not " + refStr.subSequence(1,7));
    }

    if (testStr.compareTo(refStr) != 0) {
      System.out.println(++c + ". compareTo() should return 0 in this case");
    }

    refStr += "abcd";

    if (testStr.compareTo(refStr) >= 0) {
      System.out.println(++c + ". compareTo() should return a negative in this case");
    }

    refStr = refStr.substring(0,20);

    if (testStr.compareTo(refStr) <= 0) {
      System.out.println(++c + ". compareTo() should return a positive in this case");
    }

    if (c == 0) {
      System.out.println("\nYour MyString passed all the tests. Good work!");
    } else {
      System.out.println("\nYour MyString failed " + c + " tests. Keep trying!");
    }
  }
}
