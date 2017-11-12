package academy.elqoo.java8.dateandtime;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

public class DateTime8 {

    public static final long DAYS_BETWEEN = 5;

    public static LocalDate createNewYearsEve2017(){
        return LocalDate.of(2017,12,31);
    }

    public static LocalDate[] getTwoLocalDates(){
        LocalDate[] dates = new LocalDate[2];
        dates[0] = LocalDate.now();
        dates[1] = dates[0].plusDays(DAYS_BETWEEN);
        return dates;
    }

    public static LocalDate findNextFriday13th(LocalDate from){
        throw new NotImplementedException();
    }

}
