package fr.ksuto.commons.helpers;

/**
 * Created by thomas.bouchardon on 24/10/2016!
 */
public class Strings {
    
    public static String toTitleCase(String givenString) {
        
        String[] arr         = givenString.split(" ");
        String   toTitleCase = "";
    
        for (String anArr : arr) {
            toTitleCase += Character.toUpperCase(anArr.charAt(0)) +
                           anArr.substring(1) +
                           " ";
        }
        
        return toTitleCase.trim();
    }
}
