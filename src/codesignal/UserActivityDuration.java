package codesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserActivityDuration {
    public static void main(String[] args) {
        List<String> logList = List.of("U1,100,Login","U1,200,Logout","U2,50,Login","U2,100,Logout","U1,100,Login");
        var userActivitySessions = userActivity(logList);
        System.out.println(userActivitySessions);
    }

    public static HashMap<String, Integer> userActivity(List<String> logs) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        record UserSession(Integer loginTime, boolean loggedIn) {};
        var sessions = new HashMap<String,UserSession>();

        for(String log : logs) {
            var parts = log.split(",");
            if(parts.length !=3) continue;

            String user = parts[0];
            int sessionTime = Integer.parseInt(parts[1]);
            String action = parts[2];

            switch(action) {
                case "Login" -> sessions.put(user, new UserSession(sessionTime,true));
                case "Logout" -> {
                    var usrSesn = sessions.get(user);
                    int totalSessionTime =sessionTime - usrSesn.loginTime;
                    resultMap.merge(user, totalSessionTime, Integer::sum);
                }
                default -> {}
            }
        }
        return resultMap;
    }
}




