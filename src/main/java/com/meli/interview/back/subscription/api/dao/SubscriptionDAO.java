package com.meli.interview.back.subscription.api.dao;

import com.meli.interview.back.subscription.api.models.Subscription;
import com.meli.interview.back.subscription.api.models.User;

import java.util.List;

public interface SubscriptionDAO {

    public List<Subscription> findSubscriptionByUser(User user);

}
