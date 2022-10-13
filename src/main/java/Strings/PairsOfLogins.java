package Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsOfLogins {

    public int countFamilyLogins(List<String> logins) {

        if(logins.size()<2) return 0;

        Map<String, Integer> loginsMap = new HashMap<>();
        int count = 0;
        for (String login : logins) {
            if(login.isEmpty()) break;
            loginsMap.putIfAbsent(login, 0);
            loginsMap.put(login, loginsMap.get(login) + 1);
        }

        for (String login : logins) {
            StringBuilder res = new StringBuilder();

            for (char c : login.toCharArray()) {
                res.append((char)(((c - 'a' + 1) % 26) + 'a'));
            }
            if(loginsMap.containsKey(res.toString())){
                count = count+loginsMap.get(res.toString());
            }
        }

        return count;
    }
}
