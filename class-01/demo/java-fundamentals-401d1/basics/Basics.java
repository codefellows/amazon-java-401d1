// must import things built in Java other than the very basics
import java.util.Calendar;
import java.text.SimpleDateFormat;

// The class name must be capitalized and the same as the fileName
public class Basics {
  // running a file in Java means running the main method
  // the main method always look exactly like this
  public static void main(String[] args){
    System.out.println("Hello everyone it is such a  nice morning");

    if(isGingerCold()){
      System.out.println("get ginger a sweater");
    } else {
      System.out.println("maybe we should shave ginger");
    }

    for(int i = 0; i < 10; i++){
      System.out.println(i);
    }

    while(true){
      System.out.println("stop!");
      break;
    }

    String[] favoriteMovies = new String[3];
    favoriteMovies[0] = "Avengers Endgame";
    favoriteMovies[1] ="Forest Gump";
    favoriteMovies[2] ="Terminator Judgement Day";

    int[] favoriteNumbers = new int[]{7, 16, 12, 240, 1000000000, 81};

    for(int i = 0; i < favoriteMovies.length; i++){
      System.out.println(favoriteMovies[i]);
    }
  }

//writing a method
// for now they always start with public static
// they return something (the type)
// followed by the name of the metod
// public static Type nameOfMethod(){}
// fruitful method
  public static boolean isGingerCold(){

// make a calendar instance
    Calendar cal = Calendar.getInstance();
    // create a format, and pass it the time from the calendar
    // save it into a variable that is a String
    String currentMonth = new SimpleDateFormat("MMM").format(
      cal.getTime()
      );
    // System.out.println(currentMonth);

// Objects are not equal when compared with ==
// Things that are objects have a Capital Letter in their variable type
    if(currentMonth.equals("Nov") || currentMonth.equals( "Dec") || currentMonth.equals( "Jan") || currentMonth.equals( "Feb")){
      return true;
    } else {
      return false;
    }

    // primitives can be compared with ==
  //int, long, float, char, byte, short, double, boolean

    // check the current month
    // ginger is cold in November, december, january, february
  }

}