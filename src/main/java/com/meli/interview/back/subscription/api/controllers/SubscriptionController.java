package com.meli.interview.back.subscription.api.controllers;

import com.meli.interview.back.subscription.api.Services.SubscriptionService;
import com.meli.interview.back.subscription.api.models.Subscription;
import com.meli.interview.back.subscription.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/{user}/totalCost")
    public @ResponseBody ResponseEntity<Float> getUserSubscriptionCost(@PathVariable  User  user,
            @AuthenticationPrincipal User principal) {
        return principal != null ? new ResponseEntity<Float>(
                subscriptionService.getUserSubscriptionsCost(user,principal), HttpStatus.OK )
                : new ResponseEntity<Float>(0f, HttpStatus.BAD_REQUEST);
    }
}
