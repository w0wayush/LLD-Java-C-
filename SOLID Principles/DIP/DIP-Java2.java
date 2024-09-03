/*
// Violates DIP
// Higher level module: Application
class Application {
    private FileLogger logger;

    public Application(FileLogger logger) {
        this.logger = logger;
    }

    public void process() {
        logger.log("Application started");
        // Additional logic here
    }
}

// Lower level module: FileLogger
class FileLogger {

    public void log(String message) {
        // Code to write the message to a file
        System.out.println("Log method called");
    }
}

// New Lower level module: ConsoleLogger
class ConsoleLogger {

    public void clog(String message) {
        // Code to write the message to a file
        System.out.println("Clog method called");
    }
}

public class Example {
    public static void main(String[] args) {
        FileLogger logger = new FileLogger();
        ConsoleLogger clogger = new ConsoleLogger();
        // We can't pass the cloogger as params in Application(clogger) without modifying the Application, other wise program gives an compile time error.
        Application app = new Application(logger);
        app.process();
    }
}

*/


/* Not Violates the DIP
// Step 1: Define the Abstraction

// Interface : Ilogger
interface ILogger {
    void log(String message);
}

// Step 2: Implement the Abstraction

// LLM 1: ConsoleLogger
class FileLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }
}

// LLM 2: ConsoleLogger
class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}

// LLM 3: ExternalServiceLogger
class ExternalServiceLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("ExternalServiceLogger: " + message);
        // Code to send the message to an external service
        // This could involve HTTP requests, dealing with authentication, etc.
    }
}

// Step 3: Higher level app now depends upon Abstraction

// HLM 1: Application
class Application {
    private ILogger logger;

    public Application(ILogger logger) {
        this.logger = logger;
    }

    public void process() {
        logger.log("Application started");
        // Additional logic here
    }
}

public class Example {
    public static void main(String[] args) {
        ILogger fileLog = new FileLogger();
        ILogger consoleLog = new ConsoleLogger();
        ILogger externalServiceLog = new ExternalServiceLogger();
        
        // Now we dont need to change for passing fileLog, consoleLog, and externalServiceLog as paramas into Application
        Application app1 = new Application(fileLog);
        Application app2 = new Application(consoleLog);
        Application app3 = new Application(externalServiceLog);
        
        app1.process(); // FileLogger: Application started
        app2.process(); //  ConsoleLogger: Application started
        app3.process(); // ExternalServiceLogger: Application started
    }
}
*/

