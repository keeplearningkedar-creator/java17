package codesignal;

import java.util.*;

public class UserToActionLogLines {

    public static void main(String[] args) {
        String[] userActions = {"Kedar,A", "Kedar,U", "Kedar,D"};
        System.out.println(sortUserActions(userActions));
    }

    public static HashMap<String, List<String>> sortUserActions(String[] userActions) {
        // return for edge case
        var retMap = new HashMap<String, TreeSet<String>>();
        for(String log : userActions) {
            var parts = log.split(",");
            if(parts.length != 2) continue;
            var user = parts[0];
            var action = parts[1];
            retMap.computeIfAbsent(user,  act -> new TreeSet<String>()).add(action);
        }

        var returnMap = new HashMap<String, List<String>>();
        for(Map.Entry<String, TreeSet<String>> ev : retMap.entrySet()) {
            returnMap.put(ev.getKey(),new ArrayList<String>(ev.getValue()));
        }
        return returnMap;
    }
}
