public class ArrayReverse {
  public static void main(String[] args){
    String[] letters = new String[]{"a", "b", "c"};

    // System.out.println(reverseArray(letters));
    String[] reversed = reverseArray(letters);
    for(int i = 0; i < reversed.length; i++){
      System.out.println(reversed[i]);
    }

  }

  public static String[] reverseArray(String[] arrayToReverse){
    //your code goes here
    return arrayToReverse;
  }
}