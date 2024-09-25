package lab2;

public abstract  class GeometricShape {
    private int dimension;
    
    public int getDimension(){
        return dimension;
    }

    public void setDimension(int val){
        dimension = val;
    }

    public void displayDimension() {
        System.out.println("Dimension: " + dimension);
    }
}
