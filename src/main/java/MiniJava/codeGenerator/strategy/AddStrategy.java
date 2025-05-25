package MiniJava.codeGenerator.strategy;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.Memory;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.varType;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;

import java.util.Stack;

public class AddStrategy extends BaseCodeGenerationStrategy {
    public AddStrategy(Memory memory, SymbolTable symbolTable, Stack<Address> ss, Stack<String> symbolStack,
            Stack<String> callStack) {
        super(memory, symbolTable, ss, symbolStack, callStack);
    }

    @Override
    protected void executeStrategy(Token token) {
        Address temp = new Address(memory.getTemp(), varType.Int);
        Address s2 = ss.pop();
        Address s1 = ss.pop();

        if (s1.varType != varType.Int || s2.varType != varType.Int) {
            ErrorHandler.printError("In add two operands must be integer");
        }
        memory.add3AddressCode(Operation.ADD, s1, s2, temp);
        ss.push(temp);
    }
}
