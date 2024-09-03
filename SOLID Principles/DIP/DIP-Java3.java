/* 
//Violates DIP
// Higher level module: GoToWork
class GoToWork {
    private Metro metro;
    public GoToWork(Metro metro) {
        this.metro = metro;
    }

    public void process() {
        metro.travel("Transport started");
        // Additional logic here
    }
}

// Lower level module: Metro
class Metro {
    public void travel(String message) {
        // Code to write the message to a file
    }
}

// New Lower level module: Rapido
class Rapido {
    public void travel(String message) {
        // Code to write the message to a file
    }
}

public class Example {
    public static void main(String[] args) {
        Metro metroTransport = new Metro();
        Rapido rapidoTransport = new Rapido();
        // We can't pass the rapidoTransport as params in GoToWork(rapidoTransport) without modifying the GotoWork, other wise program gives an compile time error.
        GoToWork app = new GoToWork(metroTransport);
        app.process();
    }
}
*/



/*
// Not Violates the DIP
// Step 1: Define the Abstraction

// Interface : ITransport
interface ITransport {
    void travel(String message);
}

// Step 2: Implement the Abstraction

// LLM 1: Metro
class Metro implements ITransport {
    @Override
    public void travel(String message) {
        System.out.println("Metro: " + message);
    }
}

// LLM 2: Rapido
class Rapido implements ITransport {
    @Override
    public void travel(String message) {
        System.out.println("Rapido: " + message);
    }
}

// LLM 3: Uber
class Uber implements ITransport {
    @Override
    public void travel(String message) {
        System.out.println("Uber: " + message);
    }
}

// Step 3: Higher level app now depends upon Abstraction

// HLM 1: GoToWork
class GoToWork {
    private ITransport transport;

    public GoToWork(ITransport transport) {
        this.transport = transport;
    }

    public void process() {
        transport.travel("transport started");
        // Additional logic here
    }
}

public class Example {
    public static void main(String[] args) {
        ITransport metroTrav = new Metro();
        ITransport rapidoTrav = new Rapido();
        ITransport uberTrav = new Uber();
        
        // Now we don't need to change for passing metroTrav, rapidoTrav, and uberTrav as paramas into GoToWork
        GoToWork transport1 = new GoToWork(metroTrav);
        GoToWork transport2 = new GoToWork(rapidoTrav);
        GoToWork transport3 = new GoToWork(uberTrav);     


        transport1.process(); // Metro: transport started
        transport2.process(); // Rapido: transport started
        transport3.process(); // Uber: transport started
    }
} 
 */