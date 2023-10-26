package ipap.triangleareafx;

public class Rectangle {
    double width, length;

    public Rectangle(double width, double length) throws UnnaturalLengthEx {
        if(width<=0)
            throw new UnnaturalLengthEx("ширина должна быть положительной", width);
        if(length<=0)
            throw new UnnaturalLengthEx("длина должна быть положительной", length);
        this.width = width;
        this.length = length;
    }

    public double getArea(){
        return width*length;
    }
}
