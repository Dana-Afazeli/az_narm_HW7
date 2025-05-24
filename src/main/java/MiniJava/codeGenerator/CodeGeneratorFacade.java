package MiniJava.codeGenerator;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;

public class CodeGeneratorFacade {
    private final CodeGenerator codeGenerator;
    private boolean hasErrors;

    public CodeGeneratorFacade() {
        this.codeGenerator = new CodeGenerator();
        this.hasErrors = false;
    }

    public boolean generateCode(int action, Token token) {
        try {
            codeGenerator.semanticFunction(action, token);
            hasErrors = ErrorHandler.hasError;
            return !hasErrors;
        } catch (Exception e) {
            ErrorHandler.printError("Code generation error: " + e.getMessage());
            hasErrors = true;
            return false;
        }
    }

    public void printGeneratedCode() {
        codeGenerator.printMemory();
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public void reset() {
        hasErrors = false;
        ErrorHandler.hasError = false;
    }
}