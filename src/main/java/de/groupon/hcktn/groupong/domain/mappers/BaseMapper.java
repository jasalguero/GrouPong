package de.groupon.hcktn.groupong.domain.mappers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;

public  abstract class BaseMapper {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

    public String formatTime(final Calendar calendar) {
        return calendar == null ? "" : dateTimeFormatter.print(calendar.getTimeInMillis());
    }
}
