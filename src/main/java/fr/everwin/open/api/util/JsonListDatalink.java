package fr.everwin.open.api.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import fr.everwin.open.api.model.core.DataLink;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JsonListDatalink {

    public static class Deserializer extends JsonDeserializer<DataLink> implements ContextualDeserializer {

        private String key;

        public Deserializer() {
            super();
        }

        public Deserializer(String key) {
            super();
            this.key = key;
        }

        @Override
        public DataLink deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Map.Entry<String, DataLink> datas = jsonParser.getCodec().readValue(jsonParser, new TypeReference<>() {
            });
            return datas.getValue();
        }

        @Override
        public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
            String key = null;
            JsonListDatalinkKey ann = null;

            if (beanProperty != null) {
                ann = beanProperty.getAnnotation(JsonListDatalinkKey.class);
            }

            if (ann != null) {
                key = ann.key();
            }

            return new JsonListDatalink.Deserializer(key);
        }
    }

    public static class Serializer extends JsonSerializer<DataLink> implements ContextualSerializer {

        private String key;
        private ObjectMapper objectMapper = new ObjectMapper();

        public Serializer() {
            super();
        }

        public Serializer(String key) {
            super();
            this.key = key;
        }

        @Override
        public void serialize(DataLink dataLink, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (Objects.nonNull(dataLink)) {
                jsonGenerator.writeString(objectMapper.writeValueAsString(List.of(new AbstractMap.SimpleEntry<>(key, dataLink))));
            } else {
                jsonGenerator.writeNull();
            }
        }

        @Override
        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            String key = null;
            JsonListDatalinkKey ann = null;

            if (beanProperty != null) {
                ann = beanProperty.getAnnotation(JsonListDatalinkKey.class);
            }

            if (ann != null) {
                key = ann.key();
            }

            return new JsonListDatalink.Serializer(key);
        }
    }
}