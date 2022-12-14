package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyKey {

    int value();

}
