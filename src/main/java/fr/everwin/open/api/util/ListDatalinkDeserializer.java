package fr.everwin.open.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import fr.everwin.open.api.model.core.DataLink;

import java.io.IOException;
import java.util.Map;

public class ListDatalinkDeserializer extends JsonDeserializer<DataLink> {

    @Override
    public DataLink deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Map.Entry<String, DataLink> datas = jsonParser.getCodec().readValue(jsonParser, new TypeReference<>() {
        });
        return datas.getValue();
    }
}