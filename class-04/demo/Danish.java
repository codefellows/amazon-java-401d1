// Build a Danish class with properties like
/*
filling, topping, warm or cold, fresh or not, and cooktime and shape
*/

public class Danish {
  // Class variables can be accessed before a single instance is made
  // static means accessible globally from the class level
  // true for all instances of the class
  // public/private/null static/null Type method/propertyName 
  static String yummy = "Very Yummy";
  static boolean hasFlour = true;
  
  // instance variables also need to be declared in the class
  // private is class access
  // public is all access
  // protected is package access
  // because this is public but not static it is accessible only on instantiated Danishes
  private String filling;
  public String shape;
  public boolean warm;
  public int cooktime;


  public Danish(String filling, String shape, boolean warm, int cooktime){
    this.filling = filling;
    this.warm = warm;
    this.cooktime = cooktime;
    this.shape = shape;
    this.yummy = "blue good";
  }

// this reassigns the method toString to be ours
// the original toString if it isnt overloaded will be returning the memory location
  public String toString(){
    // return this.filling + " is a  " + this.shape + " Danish " + " that takes " + this.cooktime + " to cook";
    return String.format("%s is a %s danish that takes %d times to cook", this.filling, this.shape, this.cooktime);
  }
}