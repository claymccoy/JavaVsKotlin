package com.claymccoy.jcalc.model;

import jakarta.validation.constraints.NotNull;

public interface Calculator {
    int calculate(@NotNull  Expression expression);
}
