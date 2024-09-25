package lab2;

public class Cylinder extends GeometricShape {
    private double radius;
    private double diameter;
    private double height;

    private final int dimension = 3;

    public Cylinder(double rad, double h) {
        radius = rad;
        height = h;
        super.setDimension(dimension);
        calcVolume(rad, h);
    }

    public void setRadius(double rad) {
        radius = rad;
        diameter = 2*rad;
        calcVolume(rad);
    }
    public void setHeight(double h) {
        height = h;
        calcVolume(h);
    }


    //method overloading. not needed here and isn't right mathematically, but used as an example
    public double calcVolume(double rad, double h) {
        return 3.14*rad*rad*h;
    }
    public double calcVolume(double val) {
        if (radius==val) {
        return 3.14*val*val;
        } else if(height==val) {
            return 3.14*val;
        } else {
            return 3.14;
        }
    }

    public void getMeasures() {
        System.out.println("Radius: " + radius + ", Diameter: " + diameter + ", Height: " + height + ", Volume: " + calcVolume(radius, height));
    }

    @Override
    public void displayDimension(){
        System.out.println("New cyl Dimention: " + getDimension());
    }
}
