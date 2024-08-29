/*
// Violates LSP
// Supar Class: Human
class Human{
    public void eat(){
        System.out.println("Human is eating");
    }
    public void sleep(){
        System.out.println("Human is sleeping");
    }
    public void work(){
        System.out.println("Human can work");
    }
    public void makeDinner(){
        System.out.println("Human can make dinner");
    }
}

// Subclass: Child
class Child extends Human { 
    public void eat(){
        System.out.println("Child is eating");
    }
    public void sleep(){
        System.out.println("Child is sleeping");
    }
    // Exception 1: Child cannot work, so we don't override the work method
    // Exception 2: Child cannot make dinner, so we don't override the makeDinner method
}

// Subclass: Adult
class Adult extends Human { 
    public void eat(){
        System.out.println("Adult is eating");
    }
    public void sleep(){
        System.out.println("Adult is sleeping");
    }
    public void work(){
        System.out.println("Adult can work");
    }
    public void makeDinner(){
        System.out.println("Adult can make dinner");
    }
}

public class Example{
    public static void main(String[] args) {
        Human child = new Child();
        Human adult = new Adult();

        // Child Violates LSP
        child.eat(); // Child is eating
        child.sleep(); // Child is sleeping
        child.work(); // Human can work
        child.makeDinner(); // Human can make dinner
    

        // Only adult not Violates LSP
        adult.eat(); // Adult is eating
        adult.sleep(); // Adult is sleeping
        adult.work(); // Adult can work
        adult.makeDinner(); // Adult can make dinner        
    }
}
*/

/* 
//Not Violates LSP
// Supar Class: Human
class Human{
    public void consumerFun(Human human){
        human.eat();
        human.sleep();
    }
    public void eat(){
        System.out.println("Human is eating");
    }
    public void sleep(){
        System.out.println("Human is sleeping");
    }
}

// Interface: IDoWork
interface IDoWork{
    void work();
}

// Interface: IMakeDinner
interface IMakeDinner{
    void makeDinner();
}


// Subclass: Child
class Child extends Human { 
    public void eat(){
        System.out.println("Child is eating");
    }
    public void sleep(){
        System.out.println("Child is sleeping");
    }
}

// Subclass: Adult
class Adult extends Human implements IDoWork, IMakeDinner { 
    public void eat(){
        System.out.println("Adult is eating");
    }
    public void sleep(){
        System.out.println("Adult is sleeping");
    }
    public void work(){
        System.out.println("Adult can work");
    }
    public void makeDinner(){
        System.out.println("Adult can make dinner");
    }
}

public class Example{
    public static void main(String[] args) {
        Human human = new Human();
        Human child = new Child();
        Human adult = new Adult();

        human.consumerFun(human);     
        human.consumerFun(child); 
        human.consumerFun(adult);
    }
}

Expected Output:
Human is sleeping
Child is eating
Child is sleeping
Adult is eating
Adult is sleeping
*/ 