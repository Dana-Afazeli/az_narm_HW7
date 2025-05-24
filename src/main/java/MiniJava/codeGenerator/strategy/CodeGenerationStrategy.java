package MiniJava.codeGenerator.strategy;

import MiniJava.scanner.token.Token;

public interface CodeGenerationStrategy {

    boolean execute(Token token);
}
