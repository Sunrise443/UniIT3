package lab2;

public class Globe extends GeometricShape {
    private double diameter;
    private double volume;
    private double radius = 1;
    private double surfuceArea;

    private final int dimension = 3;
    private int id;
    static int counter = 1;
    
    public Globe(double rad){
        radius = rad;
        id = counter++;
        super.setDimension(dimension);
        setSurfaceArea(radius);
        setVolume(radius);
        setRadius(rad);
    }
    public Globe(){
        this(1);
    }
    public int getId(){
        return id;
    }

    public void setRadius (double val) {
        radius = val;
        diameter = val*2;
        setSurfaceArea(radius);
        setVolume(radius);
    }
    public void setDiameter (double val) {
        diameter = val;
        radius = val/2;
        setSurfaceArea(radius);
        setVolume(radius);
    }
    private void setSurfaceArea(double rad) {
        surfuceArea = 4*3.14*rad*rad;
    }
    private void setVolume(double rad) {
        volume = (4*3.14*rad*rad*rad)/3;
    }

    public double getDiameter() {
        return diameter;
    }
    public double getRadius() {
        return radius;
    }
    public double getVolume() {
        return volume;
    }
    public double getSurfaceArea() {
        return surfuceArea;
    }
}
