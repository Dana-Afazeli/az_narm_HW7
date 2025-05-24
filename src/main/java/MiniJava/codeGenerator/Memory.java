package MiniJava.codeGenerator;

import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {
    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;

    public Memory() {
        setCodeBlock(new ArrayList<_3AddressCode>());
        setLastTempIndex(getStratTempMemoryAddress());
        setLastDataAddress(getStratDataMemoryAddress());
    }

    private ArrayList<_3AddressCode> getCodeBlock() {
        return codeBlock;
    }

    private void setCodeBlock(ArrayList<_3AddressCode> codeBlock) {
        this.codeBlock = codeBlock;
    }

    private int getLastTempIndex() {
        return lastTempIndex;
    }

    private void setLastTempIndex(int lastTempIndex) {
        this.lastTempIndex = lastTempIndex;
    }

    private int getLastDataAddress() {
        return lastDataAddress;
    }

    private void setLastDataAddress(int lastDataAddress) {
        this.lastDataAddress = lastDataAddress;
    }

    private int getStratTempMemoryAddress() {
        return stratTempMemoryAddress;
    }

    private int getStratDataMemoryAddress() {
        return stratDataMemoryAddress;
    }

    private int getDataSize() {
        return dataSize;
    }

    private int getTempSize() {
        return tempSize;
    }

    public int peekTemp() {
        return getLastTempIndex();
    }

    public int peekDataAddress() {
        return getLastDataAddress();
    }

    public int getCurrentCodeBlockAddress() {
        return getCodeBlock().size();
    }

    public void incrementTemp() {
        setLastTempIndex(getLastTempIndex() + getTempSize());
    }

    public void incrementDataAddress() {
        setLastDataAddress(getLastDataAddress() + getDataSize());
    }

    public int getTemp() {
        int temp = peekTemp();
        incrementTemp();
        return temp;
    }

    public int getDateAddress() {
        int address = peekDataAddress();
        incrementDataAddress();
        return address;
    }

    public int saveMemory() {
        getCodeBlock().add(new _3AddressCode());
        return getCodeBlock().size() - 1;
    }

    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().add(new _3AddressCode(op, opr1, opr2, opr3));
    }

    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        getCodeBlock().remove(i);
        getCodeBlock().add(i, new _3AddressCode(op, opr1, opr2, opr3));
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < getCodeBlock().size(); i++) {
            System.out.println(i + " : " + getCodeBlock().get(i).toString());
        }
    }
}

class _3AddressCode {
    private Operation operation;
    private Address Operand1;
    private Address Operand2;
    private Address Operand3;

    public _3AddressCode() {
    }

    public _3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        setOperation(op);
        setOperand1(opr1);
        setOperand2(opr2);
        setOperand3(opr3);
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Address getOperand1() {
        return Operand1;
    }

    public void setOperand1(Address operand1) {
        Operand1 = operand1;
    }

    public Address getOperand2() {
        return Operand2;
    }

    public void setOperand2(Address operand2) {
        Operand2 = operand2;
    }

    public Address getOperand3() {
        return Operand3;
    }

    public void setOperand3(Address operand3) {
        Operand3 = operand3;
    }

    public String toString() {
        if (getOperation() == null) return "";
        StringBuffer res = new StringBuffer("(");
        res.append(getOperation().toString()).append(",");
        if (getOperand1() != null) res.append(getOperand1().toString());
        res.append(",");
        if (getOperand2() != null) res.append(getOperand2().toString());
        res.append(",");
        if (getOperand3() != null) res.append(getOperand3().toString());
        res.append(")");
        return res.toString();
    }
}
