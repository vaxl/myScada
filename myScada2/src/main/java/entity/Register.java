package entity;

import types.ProtocolTypes;
import types.RegTypes;

public class Register implements Comparable<Register>{
    private ProtocolTypes protocol;
    private RegTypes type;
    private  int id;
    private int reg;
    private int value;
    private String name;
    private int num = 1;
    private String description = "";

    public String getDescription() {
        return description;
    }

    public Register setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getNum() {
        return num;
    }

    public Register setNum(int num) {
        this.num = num;
        return this;
    }

    public RegTypes getType() {
        return type;
    }

    public Register setType(RegTypes type) {
        this.type = type;
        return this;
    }

    public int getId() {
        return id;
    }

    public Register setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Register setName(String name) {
        this.name = name;
        return this;
    }

    public int getValue() {
        return value;
    }

    public Register setValue(int value) {
        this.value = value;
        return this;
    }

    public int getReg() {
        return reg;
    }

    public Register setReg(int reg) {
        this.reg = reg;
        return this;
    }

    @Override
    public String toString() {
        return "Register{" +
                "type=" + type +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", reg=" + reg +
                '}';
    }


    public int compareTo(Register o) {
        return this.getReg()-o.getReg();
    }
}
