package com.meli.interview.back.subscription.api.models;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.meli.interview.back.subscription.api.models.enums.Partner;
import lombok.*;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription extends SubsSerializable {
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Long id;
    private float price;
    private Partner partner;
    @ManyToOne
    private User user;


    @Override
    void addFieldsToJson(JsonGenerator jgen) throws IOException {
        jgen.writeNumberField("id",id);
        jgen.writeNumberField("price",price);
        jgen.writeStringField("partner", getPartner().name());

        jgen.writeFieldName("user");
                jgen.writeStartObject();
                jgen.writeNumberField("id", getUser().getId());
                jgen.writeStringField("name", getUser().getName());
                jgen.writeEndObject();
        }

}
