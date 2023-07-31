package com.crm.group.model;

public enum StatusClient {
    STATUS1("Active", 0),
    STATUS2("Inactive", 1);

    private final String value;
    private final Integer intValue;

    private StatusClient(String value, Integer intValue) {
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
