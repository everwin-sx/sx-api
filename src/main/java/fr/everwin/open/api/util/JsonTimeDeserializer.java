package fr.everwin.open.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JsonTimeDeserializer extends JsonDeserializer<Date> {

    public static DateFormat getDateTimeFormat() {
        final DateFormat df = new SimpleDateFormat("HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("CET"));
        return df;
    }

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException {
        DateFormat formatter = getDateTimeFormat();
        String dateStr = jsonparser.getText();
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
