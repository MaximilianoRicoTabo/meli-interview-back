package com.meli.interview.back.subscription.api.models;

import com.fasterxml.jackson.core.JsonGenerator;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends SubsSerializable {

    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private  Long id;
    private String name;
    @OneToMany
    @Singular
    private List<Subscription> subscriptions;
    @ManyToMany
    @Singular
    private List<User> friends;

    @Transient
    public float getTotalSubscriptionCost() {
        //lambda doesn't like float yet, grrrr
        float total = 0;
        for(Subscription s : subscriptions) {
            total += s.getPrice();
        }
        return total;
    }

    @Override void addFieldsToJson(JsonGenerator jgen) throws IOException {
        jgen.writeNumberField("id",id);
        jgen.writeStringField("name", name);

        jgen.writeStartArray();
        List<Subscription> subscriptions = getSubscriptions();
        if(! CollectionUtils.isEmpty(subscriptions)) {
            for(Subscription s : subscriptions) {
                jgen.writeStartObject();
                jgen.writeNumberField("id", s.getId());
                jgen.writeStringField("partner", s.getPartner().name());
                jgen.writeNumberField("price", s.getPrice());
                jgen.writeEndObject();
            }
        }
        jgen.writeEndArray();

        jgen.writeStartArray();
        List<User> friends = getFriends();
        if(! CollectionUtils.isEmpty(friends)) {
            for(User friend : friends) {
                jgen.writeStartObject();
                jgen.writeNumberField("id", friend.getId());
                jgen.writeStringField("name", friend.getName());
                jgen.writeEndObject();
            }
        }
        jgen.writeEndArray();
    }
}
