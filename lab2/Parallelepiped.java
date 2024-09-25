package lab2;

public class Parallelepiped extends GeometricShape {
    public double pWidth;
    double pLength;
    private double perimeter;
    private final int dimension = 2;

    //конструкторы по умолчанию для длины и ширины
    public Parallelepiped() {
        super.setDimension(dimension);
    }

    public void setPerimeter (double w, double l){
        perimeter = w*l;
    }
    public double getPerimeter () {
        return perimeter;
    }
}
