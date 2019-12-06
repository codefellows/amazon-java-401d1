public class Bakery {
  public static void main(String[] args){
    System.out.println("come get our danishes, they  are " + Danish.yummy);

    Danish blue = new Danish("blueberry compote", "twisty", false, 7);
    Danish blue2 = new Danish("cheese", "square", true, 200);
    Danish blue3 = new Danish("apple", "apple", true, 4000);

    System.out.println("come get our blue danish, itis " + blue.yummy + " it has flower, thats " + blue.hasFlour);

    System.out.println(blue.toString());
    System.out.println(blue2.toString());
    System.out.println(blue3.toString());
    // System.out.println(Danish.filling);

  }
}