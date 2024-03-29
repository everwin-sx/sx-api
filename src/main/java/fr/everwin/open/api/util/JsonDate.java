/*
 * Copyright (C) 2019 Everwin (www.everwin.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.everwin.open.api.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fr.everwin.open.api.core.config.ConfigHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Deserializer/Serializer for date fields according to the format : yyyy-MM-dd'T'HH:mm:ss
 *
 * @author everwin-team
 */
public class JsonDate {

    public static final DateFormat df;

    static {
        df = new SimpleDateFormat(ConfigHelper.DATETIMEFORMAT);
        df.setTimeZone(TimeZone.getTimeZone(ConfigHelper.TIMEZONE));
    }

    public static class Deserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {
            String dateStr = jsonparser.getText();
            if (Objects.nonNull(dateStr) && !dateStr.trim().isEmpty()) {
                try {
                    return df.parse(dateStr);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return null;
            }
        }
    }

    public static class Serializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (Objects.nonNull(date)) {
                jsonGenerator.writeString(df.format(date));
            } else {
                jsonGenerator.writeNull();
            }
        }
    }

}
