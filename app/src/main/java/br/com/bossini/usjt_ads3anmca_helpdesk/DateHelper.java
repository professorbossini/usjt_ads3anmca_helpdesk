package br.com.bossini.usjt_ads3anmca_helpdesk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy");

    public static String format (Date date){
        return sdf.format(date);
    }


}
