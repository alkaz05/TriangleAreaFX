package ipap.triangleareafx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRectangle {
    @Test
    void test1() throws UnnaturalLengthEx {
        Rectangle r = new Rectangle(10, 25);
        Assertions.assertEquals(250, r.getArea());

        r = new Rectangle(25, 10);
        Assertions.assertEquals(250, r.getArea());
    }
    @Test
    void test2(){
        Assertions.assertThrows(GeometryException.class, ()->new Rectangle(-5, 25));
        Assertions.assertThrows(GeometryException.class, ()->new Rectangle(36, -6));
        Assertions.assertThrows(GeometryException.class, ()->new Rectangle(0, 25));
        Assertions.assertThrows(GeometryException.class, ()->new Rectangle(-5, 0));

        Assertions.assertDoesNotThrow(()->new Rectangle(5, 5));
    }
}
