package com.previred.desafio.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * En un rango de fechas, se obtienen todos los meses en su dia primero
 * @author samanzanom@gmail.com
 */
public class BetweenDates {

    private final LocalDate minDate;
    private final LocalDate maxDate;

    public BetweenDates (LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    /**
     * Se encarga de buscar las fechas
     * @return
     */
    public String[] getDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate nextMonth = minDate;
        ArrayList<String> dates = new ArrayList<>();
        if(minDate.getDayOfMonth() == 1)
            dates.add(minDate.format(formatter));
        while(nextMonth.isBefore(maxDate) || nextMonth.isBefore(maxDate)) {
            nextMonth = nextMonth.plusMonths(1).withDayOfMonth(1);
            if(nextMonth.isBefore(maxDate))
                dates.add(nextMonth.format(formatter));
        }
        if(maxDate.getDayOfMonth() == 1)
            dates.add(maxDate.format(formatter));

        return dates.toArray(new String[0]);
    }
}
