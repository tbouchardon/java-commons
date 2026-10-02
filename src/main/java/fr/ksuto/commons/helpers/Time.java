package fr.ksuto.commons.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by thomas.bouchardon on 16/03/2017!
 */
public class Time {
    
    public static String getTime() {
        
        return new SimpleDateFormat("HH:mm:ss", Locale.FRANCE).format(new Date());
    }
}
