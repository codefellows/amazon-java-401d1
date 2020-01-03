package demo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCats() {
        Cat teddy = new Cat(true, 5, 11);
        teddy.meow();
        System.out.println(teddy.toString());

        // cats cannot be bobcats
        ((Bobcat) teddy).kill();
    }
}