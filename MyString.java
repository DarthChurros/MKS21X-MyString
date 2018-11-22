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
    for (int i = 0; i < Math.min(length(),other.length()); i++) {
      if (charAt(i) != other.charAt(i)) {
        return (charAt(i) - other.charAt(i));
      }
    }
    return length() - other.length();
  }
}
