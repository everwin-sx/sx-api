package fr.everwin.open.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import fr.everwin.open.api.core.config.ConfigHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JsonTimeDeserializer extends JsonDeserializer<Date> {

    public static final DateFormat df;

    static {
        df = new SimpleDateFormat(ConfigHelper.TIMEFORMAT);
        df.setTimeZone(TimeZone.getTimeZone(ConfigHelper.TIMEZONE));
    }

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException {
        String dateStr = jsonparser.getText();
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
