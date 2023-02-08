package com.meli.interview.back.subscription.api.Services;

import com.meli.interview.back.subscription.api.models.User;

public interface SubscriptionService {
    Float getUserSubscriptionsCost(User userToCalc, User loggedInUser);
}
