package com.meli.interview.back.subscription.api.Services;

import com.meli.interview.back.subscription.api.dao.SubscriptionDAO;
import com.meli.interview.back.subscription.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario
     * se encuentre en su lista de amigos
     * @param userToCalc the {@link User}
     * @param loggedInUser the {@link User}
     * @return costo total de la suscripciones del user si  esta entre los amigos, sino null;
     */
    @Override
    public Float getUserSubscriptionsCost(User userToCalc, User loggedInUser) {
        return userToCalc.getFriends().contains(loggedInUser) ?
                userToCalc.getTotalSubscriptionCost() : null;
    }
}
