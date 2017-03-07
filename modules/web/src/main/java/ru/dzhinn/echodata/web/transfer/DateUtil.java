package ru.dzhinn.echodata.web.transfer;



import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 7/25/13 7:27 PM
 *
 * @author Alexander V. Zinin (mail@zinin.ru)
 */
public class DateUtil {
    public static final ThreadSafeDateFormat fullDateFormat = new ThreadSafeDateFormat("dd.MM.yyyy HH:mm:ss");
    public static final ThreadSafeDateFormat readableDateFormat = new ThreadSafeDateFormat("d MMMM yyyy, HH:mm", LangConstants.LOCALE);
    public static final ThreadSafeDateFormat onlyDateFormat = new ThreadSafeDateFormat("d MMMM yyyy", LangConstants.LOCALE);
    public static final ThreadSafeDateFormat fullDateWithoutSeconds = new ThreadSafeDateFormat("dd.MM.yyyy HH:mm");
    public static final ThreadSafeDateFormat simpleDateFormat = new ThreadSafeDateFormat("dd.MM.yyyy", LangConstants.LOCALE);
    public static final ThreadSafeDateFormat reportDateFormat = new ThreadSafeDateFormat("dd-MM-yyyy", LangConstants.LOCALE);

    private static final String[] MONTHS = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    private static final String[] MONTHS_GENETIVE = {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};

    public static String formatDateFull(Date date) {
        return fullDateFormat.format(date);
    }

    public static String formatDateReadable(Date date) {
        String result = readableDateFormat.format(date);

        return replaceToGenetive(result);
    }

    public static String formatOnlyDate(Date date) {
        return replaceToGenetive(onlyDateFormat.format(date));
    }

    public static String formatSimpleDate(Date date) {
        if (date == null){
            return null;
        }
        return replaceToGenetive(simpleDateFormat.format(date));
    }
    public static String formatReportDate(Date date) {
        return replaceToGenetive(reportDateFormat.format(date));
    }

    public static Date parseDate(String date) throws ParseException {
        return fullDateFormat.parse(date);
    }

    public static Date parseSimpleDate(String date){

        if (date == null){
            return null;
        }

        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date parseDateWithoutSeconds(String date) throws ParseException {
        return fullDateWithoutSeconds.parse(date);
    }

    public static String replaceGenetive(String dateString) {
        String result = dateString;
        for (int i = 0; i < MONTHS_GENETIVE.length; i++) {
            String month = MONTHS_GENETIVE[i];
            Matcher m = Pattern.compile(month, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(result);
            if (m.find()) {
                result = m.replaceAll(MONTHS[i].toLowerCase());
            }
        }

        return result;
    }

    public static String replaceToGenetive(String dateString) {
        String result = dateString;
        for (int i = 0; i < MONTHS.length; i++) {
            String month = MONTHS[i];
            Matcher m = Pattern.compile(month, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(result);
            if (m.find()) {
                result = m.replaceAll(MONTHS_GENETIVE[i].toLowerCase());
            }
        }

        return result;
    }
}