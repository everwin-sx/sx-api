package fr.everwin.open.api.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonTimeDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

		DateFormat formatter = XmlTimeAdapter.getDateTimeFormat();
		String dateStr = jsonparser.getText();
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
