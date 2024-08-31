/* 
// Violates ISP
// Large Interface: Shape
interface Shape{
    double area();
    double volume();
}

class Square implements Shape {
    @Override
    public double area() {
        System.out.println("Square have area");
        double area = 1.2;
        return area;
    }
    @Override
    public double volume() {
        // Square don't have volume, so this method should not be here (Violates ISP)
        System.out.println("Square does not have volume");
        double volume = 2.1;
        return volume;
    }
}

class Cube implements Shape{
    @Override
    public double area() {
        System.out.println("Cube have area");
        double area = 2.5;
        return area;
    }
    @Override
    public double volume() {
        System.out.println("Cube have surface area");
        double volume = 3.5;
        return volume;
    }
}

public class Example {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape cube = new Cube();

        // Square Violates ISP
        square.area(); // Square have area
        square.volume(); // Square does not have volume 

        // Cube not Violates ISP
        cube.area(); // Cube have area
        cube.volume(); // Cube have surface area
    }
}

*/


/* Not Violates ISP
// Large Interface: Shape
interface Shape{
    void display(double val);
}

// Small Interface: ITwoDShape
interface ITwoDShape extends Shape{
    double area();
}

// Small Interface: IThreeDShape
interface IThreeDShape extends Shape{
    double volume();
}

class Square implements ITwoDShape {
    private double side;
    Square(double side){
        this.side = side;
    }

    @Override
    public void display(double area) {
        System.out.printf("Square have area: %f", area);        
    }

    @Override
    public double area() {
        double area = side*side;
        return area;
    }
}

class Cube implements IThreeDShape {
    private double side;
    Cube(double side){
        this.side = side;
    }

    @Override
    public void display(double volume) {
        System.out.printf("Cube has volume: %f", volume);        
    }

    @Override
    public double volume() {
        double volume = side*side*side;
        return volume;
    }
}

public class Example {
    public static void main(String[] args) {
        ITwoDShape square = new Square(2.1);
        IThreeDShape cube = new Cube(4);

        // Square Violates ISP
        double area = square.area(); 
        square.display(area); // Square have area: 4.410000

        // Cube Violates ISP
        double volume = cube.volume();
        cube.display(volume); // Cube has volume: 64.000000
    }
}

*/