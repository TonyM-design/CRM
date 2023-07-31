package com.crm.group.model;

public enum StatusOrder {
    STATUS1("status0", 0),
    STATUS2("status1", 1),
    STATUS3("status2", 2);

    private final String value;
    private final Integer intValue;

    private StatusOrder(String value, Integer intValue) {
        this.value = value;
        this.intValue = intValue;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return intValue;
    }
}

