/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask;

/**
 * The interface Block consists method void run() with exception.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public interface Block {

    /**
     * The method containing an error.
     */
    default void run() throws Exception {
        int a = 5;
        int b = 0;

        a /= b;
    }

}
