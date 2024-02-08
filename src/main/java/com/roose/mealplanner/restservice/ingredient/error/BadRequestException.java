package com.roose.mealplanner.restservice.ingredient.error;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
