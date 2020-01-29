/**
 * 
 */
package fr.everwin.open.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * XML adapter for time
 * @author everwin-team
 */
public class XmlTimeAdapter extends XmlAdapter<String, Date> {

	private DateFormat dateFormat = getDateTimeFormat();

	public static DateFormat getDateTimeFormat() {
		final DateFormat df = new SimpleDateFormat("HH:mm");
		df.setTimeZone(TimeZone.getTimeZone("CET"));
		return df;
	}

	@Override
	public String marshal(Date v) throws Exception {
		return dateFormat.format(v);
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		return dateFormat.parse(v);
	}
}
