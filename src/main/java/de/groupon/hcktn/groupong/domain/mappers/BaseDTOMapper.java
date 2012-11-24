package de.groupon.hcktn.groupong.domain.mappers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;

public abstract class BaseDTOMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

    public String formatTime(final Calendar calendar) {
        return calendar == null ? "" : dateTimeFormatter.print(calendar.getTimeInMillis());
    }

    public Calendar formatTime(final String dateTime) {
        if (StringUtils.hasText(dateTime)) {
            try {
                final Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(dateTimeFormatter.parseMillis(dateTime));
                return instance;
            } catch (IllegalArgumentException e) {
                return Calendar.getInstance();
            }
        } else {
            return Calendar.getInstance();
        }
    }
}
