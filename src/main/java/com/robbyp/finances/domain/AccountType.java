package com.robbyp.finances.domain;

public enum AccountType {
    CURRENT("cur"), SAVINGS("sav"), CREDITCARD("cre"), MORTGAGE("mor");

    AccountType(String id) {
        this.id = id;
    }

    public final String getId() {
        return id;
    }

    private final String id;
}
