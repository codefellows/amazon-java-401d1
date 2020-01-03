package demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BobcatTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBobcat() {
        Bobcat robert = new Bobcat();
        robert.meow();
        robert.kill();
        System.out.println(robert.hasMurdered());
        System.out.println(robert);

        // can always assign an instance of a subclass to a variable whose type is the superclass
        Cat jimbob = new Bobcat();
        // it can act like the parent class
        jimbob.meow();
        // but because the variable is more generic, Java forgets that it can be more special
        // and act like a bobcat
        // we can cast it, but it's dangerous, could cause a ClassCastException if we're wrong
        ((Bobcat)jimbob).kill();


    }
}