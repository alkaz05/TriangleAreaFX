package ipap.triangleareafx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void test1() throws UnnaturalLengthEx, ImpossibleTriangleEx {
        Triangle t = new Triangle(10, 10, 10);
        Assertions.assertEquals(30, t.getPerimeter());
        t = new Triangle(4, 5, 3);
        Assertions.assertEquals(12, t.getPerimeter());
        Assertions.assertEquals(0.99, new Triangle(0.33, 0.33, 0.33).getPerimeter());
    }

    @Test
    void test2(){
        Assertions.assertDoesNotThrow(()->new Triangle(3, 4, 5));
    }
    @Test
    void test3(){
        Assertions.assertThrows(ImpossibleTriangleEx.class, ()->new Triangle(3, 4, 10));
        Assertions.assertThrows(UnnaturalLengthEx.class, ()->new Triangle(3, 4, 0));
        Assertions.assertThrows(UnnaturalLengthEx.class, ()->new Triangle(-3, 4, 5));
        Assertions.assertThrows(UnnaturalLengthEx.class, ()->new Triangle(3, -4, -5));
    }
}
