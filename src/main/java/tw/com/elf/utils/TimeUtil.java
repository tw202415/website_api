package tw.com.elf.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtil {
	
    public static Date strToDate(String year, String month, String day) {
        LocalDate localDate = LocalDate.of(
            Integer.parseInt(year),
            Integer.parseInt(month),
            Integer.parseInt(day)
        );
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
