package ru.job4j.chess;

public class ImpossibleMovementException extends Exception {
    public ImpossibleMovementException(String message) {
        super(message);
    }
}
