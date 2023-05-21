package com.shg.bmapi.enums;

public enum InheritFromParentEnum {

    NOT_SUPPORTED("NOT_SUPPORTED"),
    INHERITED_FROM_PARENT("INHERITED_FROM_PARENT"),
    BROKEN_INHERITANCE("BROKEN_INHERITANCE");

    private final String key;

    InheritFromParentEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
