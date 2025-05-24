package MiniJava;
import java.io.FileNotFoundException;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.parser.ParserFacade;

public class Main {
    public static void main(String[] args) {
        ParserFacade parser = new ParserFacade();
        try {
            boolean success = parser.parseFile("src/main/resources/code");
            if (!success) {
                System.out.println("Parsing completed with errors.");
            } else {
                System.out.println("Parsing completed successfully.");
            }
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}
