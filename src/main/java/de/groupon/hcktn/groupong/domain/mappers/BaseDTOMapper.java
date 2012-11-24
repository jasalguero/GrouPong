package de.groupon.hcktn.groupong.domain.mappers;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import java.util.Calendar;

public abstract class BaseDTOMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

    public String formatTime(final Long timeInMilis) {
        if (timeInMilis == null ) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilis);
        return calendar == null ? "" : dateTimeFormatter.print(calendar.getTimeInMillis());
    }

    public Long formatTime(final String dateTime) {
        if (StringUtils.hasText(dateTime)) {
            try {
                final Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(dateTimeFormatter.parseMillis(dateTime));
                return instance.getTimeInMillis();
            } catch (IllegalArgumentException e) {
                return Calendar.getInstance().getTimeInMillis();
            }
        } else {
            return Calendar.getInstance().getTimeInMillis();
        }
    }
}
