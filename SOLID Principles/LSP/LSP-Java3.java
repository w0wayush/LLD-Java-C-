/* Violates LSP
// Supar Class: Vehicle
class Vehicle{
    public void startEngine(){
        System.out.println("Vehicle may have engine");
    }
    public void doMovement(){
        System.out.println("Vehicle can move");
    }
    public void fly(){
        System.out.println("Vehicle may fly");
    }
}

// Subclass: Car
class Car extends Vehicle { 
    @Override
    public void startEngine(){
        System.out.println("Car have engine");
    }
    @Override
    public void doMovement() {
        System.out.println("Car can move");
    }
    // Exception 1: Car cannot fly, so we don't override the fly method
}

// Subclass: Cycle
class Cycle extends Vehicle { 
    // Exception 1: Cycle does not have engine, so we don't override the startEngine method
    @Override
    public void doMovement() {
        System.out.println("Cycle can move");
    }
    // Exception 2: Cycle cannot fly, so we don't override the fly method
}

// Subclass: Airplane
class Airplane extends Vehicle { 
    @Override
    public void startEngine() {
        System.out.println("Airplane have engine");
    }
    @Override
    public void doMovement() {
        System.out.println("Airplane can move");
    }
    @Override
    public void fly() {
        System.out.println("Airplane can fly");
    }
}

public class Example{
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle cycle = new Cycle();
        Vehicle airplane = new Airplane();

        // Car Violates LSP
        car.startEngine(); // Car have engine
        car.doMovement(); // Car can move
        car.fly(); // Vehicle may fly

        // Cycle Violates LSP
        cycle.startEngine(); // Vehicle may have engine
        cycle.doMovement(); // Cycle can move
        cycle.fly(); // Vehicle may fly

        // Only Airplane not Violates LSP
        airplane.startEngine(); // Airplane have engine
        airplane.doMovement(); // Airplane can move
        airplane.fly(); // Airplane can fly
    }
}

*/


/* Not Violates LSP

// Supar Class: Vehicle
class Vehicle{
    // Consumer Method
    public void consumerFun(Vehicle vehicle){
        vehicle.doMovement();
    }
    public void doMovement(){
        System.out.println("Vehicle can move");
    }
}


// Interface: IHaveEngine
interface IHaveEngine {
    void startEngine();
}

// Interface: IFlyable
interface IFlyable{
    void fly();
}

// Subclass: Car
class Car extends Vehicle implements IHaveEngine{ 
    @Override
    public void startEngine(){
        System.out.println("Car have engine");
    }
    @Override
    public void doMovement() {
        System.out.println("Car can move");
    }
}

// Subclass: Cycle
class Cycle extends Vehicle { 
    @Override
    public void doMovement() {
        System.out.println("Cycle can move");
    }
}

// Multiple Inheritance for Airplane
// interface IFlyable_IHaveEngine extends IHaveEngine, IFlyable{}

// Subclass: Airplane
class Airplane extends Vehicle implements IHaveEngine, IFlyable { 
    @Override
    public void startEngine() {
        System.out.println("Airplane have engine");
    }
    @Override
    public void doMovement() {
        System.out.println("Airplane can move");
    }
    @Override
    public void fly() {
        System.out.println("Airplane can fly");
    }
}

public class Example{
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle car = new Car();
        Vehicle cycle = new Cycle();
        Vehicle airplane = new Airplane();

        // Meaning Of Substitution: Any derived class should be able to substitute its parent class without the consumer knowing it
        vehicle.consumerFun(vehicle); // Vehicle can move
        vehicle.consumerFun(car); // Car can move
        vehicle.consumerFun(cycle); // Cycle can move
        vehicle.consumerFun(airplane); // Airplane can move
    }
}
*/
