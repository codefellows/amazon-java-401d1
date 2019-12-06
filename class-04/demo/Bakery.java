public class Bakery {
  // args is the list of arguments passed to the file from the command line
  public static void main(String[] args){

    System.out.println(args.length);
    for(int i = 0; i < args.length; i++){
      System.out.println(args[i]);
    }

    System.out.println("come get our danishes, they  are " + Danish.yummy);

    Danish blue = new Danish("blueberry compote", "twisty", false, 7);
    Danish blue2 = new Danish("cheese", "square", true, 200);
    Danish blue3 = new Danish("apple", "apple", true, 4000);

    // System.out.println("come get our blue danish, itis " + blue.yummy + " it has flower, thats " + blue.hasFlour);

    // System.out.println(blue.toString());
    // System.out.println(blue2.toString());
    // System.out.println(blue3.toString());

    // System.out.println( "this is a string plus a string " + blue);

    // System.out.println(blue2);
    // System.out.println(Danish.filling);

  }
}