package MiniJava.codeGenerator.strategy;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.Memory;
import MiniJava.semantic.symbol.SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CodeGenerationStrategyFactory {
    private final Map<Integer, CodeGenerationStrategy> strategyCache;
    private final Memory memory;
    private final SymbolTable symbolTable;
    private final Stack<Address> ss;
    private final Stack<String> symbolStack;
    private final Stack<String> callStack;

    public CodeGenerationStrategyFactory(Memory memory, SymbolTable symbolTable, Stack<Address> ss,
            Stack<String> symbolStack, Stack<String> callStack) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.ss = ss;
        this.symbolStack = symbolStack;
        this.callStack = callStack;
        this.strategyCache = new HashMap<>();
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategyCache.put(10, new AddStrategy(memory, symbolTable, ss, symbolStack, callStack));
    }

    public CodeGenerationStrategy getStrategy(int operationCode) {
        return strategyCache.get(operationCode);
    }
}
