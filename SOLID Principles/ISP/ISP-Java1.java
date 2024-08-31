/* 
//Violates ISP
// Large Interface: IWorker
interface IWorker{
    void work();
    void eat();
}

class Human implements IWorker{
    @Override
    public void work() {
        System.out.println("Human (Manager) can work");
    }

    @Override
    public void eat() {
        System.out.println("Human (Manager) can eat");
    }
}

class Robot implements IWorker{
    @Override
    public void work() {
        System.out.println("Robot can work");
    }
    @Override
    public void eat() {
        // Robots don't eat, so this method should not be here (Violates ISP)
        System.out.println("Robot can't eat");
    }
}

public class Example {
    public static void main(String[] args) {
        IWorker human = new Human();
        IWorker robot = new Robot();

        // Human not Violates ISP
        human.work(); // Human (Manager) can work
        human.eat(); // Human (Manager) can eat

        // Robot Violates ISP
        robot.work(); // Robot can work
        robot.eat(); // Robot can't eat
    }
}
*/


/* Not Violates ISP
// Small Interface: IWorkable
interface IWorkable{
    void work();
}

// Small Interface: IEatable
interface IEatable{
    void eat();
}

class Human implements IWorkable, IEatable {
    @Override
    public void work() {
        System.out.println("Human (Manager) can work");
    }

    @Override
    public void eat() {
        System.out.println("Human (Manager) can eat");
    }
}

class Robot implements IWorkable{
    @Override
    public void work() {
        System.out.println("Robot can work");
    }
}

public class Example {
    public static void main(String[] args) {
        IWorkable humanWork = new Human();
        IEatable humanEat = new Human();
        IWorkable robotWork = new Robot();

        // Human not Violates ISP
        humanWork.work(); // Human (Manager) can work
        humanEat.eat(); // Human (Manager) can eat

        // Robot not Violates ISP
        robotWork.work(); // Robot can work
    }
}
*/

