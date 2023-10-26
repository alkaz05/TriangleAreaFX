package ipap.triangleareafx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestA {
    @Test
    public void testArea1() throws UnnaturalLengthEx, ImpossibleTriangleEx {
        Triangle t = new Triangle(3,4,5);
        Assertions.assertEquals(6, t.getArea());
    }
}
