package Strings;

import java.util.regex.Pattern;

public class CheckValidEmail {

    public boolean isValidEmail (String email) {

        String[] parts = email.split("@");
        if(parts.length!=2) return false;
        String namePart = parts[0].replace(".", "");
        if(!Pattern.compile("^[a-zA-Z0-9]+$").matcher(namePart).matches()){
            return false;
        }
        String[] domainParts = parts[1].split("\\.");
        return domainParts[domainParts.length-1].length() >= 2;
    }
}
