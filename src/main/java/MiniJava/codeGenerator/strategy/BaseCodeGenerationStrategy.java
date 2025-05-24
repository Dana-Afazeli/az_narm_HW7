package MiniJava.codeGenerator.strategy;

import MiniJava.Log.Log;
import MiniJava.codeGenerator.*;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.Symbol;
import MiniJava.semantic.symbol.SymbolTable;
import MiniJava.semantic.symbol.SymbolType;

import java.util.Stack;

public abstract class BaseCodeGenerationStrategy implements CodeGenerationStrategy {
    protected final Memory memory;
    protected final SymbolTable symbolTable;
    protected final Stack<Address> ss;
    protected final Stack<String> symbolStack;
    protected final Stack<String> callStack;

    public BaseCodeGenerationStrategy(Memory memory, SymbolTable symbolTable,
            Stack<Address> ss, Stack<String> symbolStack,
            Stack<String> callStack) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.ss = ss;
        this.symbolStack = symbolStack;
        this.callStack = callStack;
    }

    @Override
    public boolean execute(Token token) {
        try {
            executeStrategy(token);
            return true;
        } catch (Exception e) {
            Log.print("Code Generation Error: " + e.getMessage());
            return false;
        }
    }

    protected abstract void executeStrategy(Token token);

    protected varType getVarType(SymbolType type) {
        return type == SymbolType.Bool ? varType.Bool : varType.Int;
    }
}
