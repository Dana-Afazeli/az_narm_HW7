package MiniJava.parser;

import MiniJava.errorHandler.ErrorHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParserFacade {
    private final Parser parser;
    private boolean hasErrors;

    public ParserFacade() {
        this.parser = new Parser();
        this.hasErrors = false;
    }

    public boolean parseFile(String filePath) throws FileNotFoundException {
        try {
            parser.startParse(new Scanner(new File(filePath)));
            hasErrors = ErrorHandler.hasError;
            return !hasErrors;
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
            throw e;
        }
    }

    public boolean parseString(String sourceCode) {
        parser.startParse(new Scanner(sourceCode));
        hasErrors = ErrorHandler.hasError;
        return !hasErrors;
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public void reset() {
        hasErrors = false;
        ErrorHandler.hasError = false;
    }
}
