package lab2;

public class MainShapes {
    public static void main(String[] args) {
        Globe firstGlobe = new Globe();
        Globe secondGlobe = new Globe(20);
        System.out.println("firstGlobe id: " + firstGlobe.getId());
        System.out.println("secondGlobe id: " + secondGlobe.getId());
        System.out.println("secondGlobe volume: " + secondGlobe.getVolume());
        System.out.println("secondGlobe diameter: " + secondGlobe.getDiameter());
        //System.out.println(secondGlobe.setVolume()); - не работает тк .setVolume - pivate

        Parallelepiped firstParallelepiped = new Parallelepiped();
        Parallelepiped secondParallelepiped = new Parallelepiped();
        System.out.println("secondParallelepiped width: " + (secondParallelepiped.pWidth = 90));
        System.out.println("firstParallelepiped length: " + (firstParallelepiped.pLength = 890));
        secondParallelepiped.setPerimeter(secondParallelepiped.pWidth, 40.0);
        System.out.println("secondParallelepiped perimeter: " + secondParallelepiped.getPerimeter());
        System.out.println("firstParallelepiped dimension: " + firstParallelepiped.getDimension());
    }
}
