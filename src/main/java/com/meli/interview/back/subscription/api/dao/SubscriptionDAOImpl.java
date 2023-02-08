package com.meli.interview.back.subscription.api.dao;

import com.meli.interview.back.subscription.api.models.Subscription;
import com.meli.interview.back.subscription.api.models.User;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class SubscriptionDAOImpl  extends GenericDAO <Subscription> implements SubscriptionDAO {

    public List<Subscription> findSubscriptionByUser(User user) {
        return getCurrentSession().createQuery("FROM Subscription s "
                        + "WHERE s.user=:user")
                .setParameter("user", user)
                .list();
    }
}
