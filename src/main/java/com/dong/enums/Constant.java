package com.dong.enums;

import lombok.Getter;

@Getter
public enum Constant {

    FALSE(0),TRUE(1);

    private final int value;//是否

    Constant(int value) {
        this.value = value;
    }
}
