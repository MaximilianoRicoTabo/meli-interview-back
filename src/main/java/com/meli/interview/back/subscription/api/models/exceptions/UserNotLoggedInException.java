package com.meli.interview.back.subscription.api.models.exceptions;

public class UserNotLoggedInException extends RuntimeException {
    private static final long serialVersionUID = 8959479918185637340L;

            public UserNotLoggedInException(String message) {
                super(message);
            }

}