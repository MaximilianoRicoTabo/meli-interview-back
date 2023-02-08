package com.meli.interview.back.subscription.api.models;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serializable;

@Slf4j
public abstract class SubsSerializable implements Serializable, JsonSerializable {
    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) {
        try{
            gen.writeStartObject();
            addFieldsToJson(gen);
            gen.writeEndObject();
        } catch(JsonGenerationException jge) {
            log.error("unable to serialize " + this.getClass().getSimpleName()  + gen.toString(), jge);
        } catch(IOException ioe) {
            log.error("unable to serialize " + this.getClass().getSimpleName(), ioe);
        }
    }

    abstract void addFieldsToJson(JsonGenerator jgen) throws JsonGenerationException, IOException;

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers,
            TypeSerializer typeSer) throws IOException {

    }
}
