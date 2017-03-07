package ru.dzhinn.echodata.web.transfer;

import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Date: 7/25/13 7:28 PM
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
public class ThreadSafeDateFormat {
    private final String dateFormat;
    private final Locale locale;
    private final ThreadLocal<SoftReference<DateFormat>> cache = new ThreadLocal<SoftReference<DateFormat>>();

    public ThreadSafeDateFormat(String dateFormat) {
        this(dateFormat, Locale.getDefault());
    }

    public ThreadSafeDateFormat(String dateFormat, Locale locale) {
        this.dateFormat = dateFormat;
        this.locale = locale;
    }

    private DateFormat getDateFormat() {
        DateFormat result = null;
        if (cache.get() != null) {
            result = cache.get().get();
        }

        if (result == null) {
            result = new SimpleDateFormat(dateFormat, locale);
            SoftReference<DateFormat> softReference = new SoftReference<DateFormat>(result);
            cache.set(softReference);
        }

        return result;
    }

    public String format(Date date) {
        return getDateFormat().format(date);
    }

    public Date parse(String string) throws ParseException {
        return getDateFormat().parse(string);
    }
}