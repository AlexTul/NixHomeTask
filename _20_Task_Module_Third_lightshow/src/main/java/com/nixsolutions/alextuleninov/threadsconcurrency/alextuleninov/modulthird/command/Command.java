package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.modulthird.command;

import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.modulthird.exceptions.LightshowException;

public interface Command<T> {

    T execute() throws LightshowException;

}
