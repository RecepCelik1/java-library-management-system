import java.util.HashMap;

public class UserOPS {

    private static class Database {
        
        private static HashMap<String, User> database = new HashMap<>(); 

        static boolean NameCheck(String name) {
            return database.containsKey(name);
        }

        static int SignUp(String name, User user){
            int i = database.size();
            database.put(name, user);
            return database.size() - i;
        }

        static User LogIn(String name, String password) {
            User temp = database.get(name);
            if (temp == null) {
                return null;
            } else if (temp.password.equals(password)) {
                return temp;
            } else {
                return null;
            }
        }
    }

    public static boolean checkName(String name) {
        return Database.NameCheck(name);
    }

    public static int signUpUser(String name, User user) {
        return Database.SignUp(name, user);
    }

    public static User logInUser(String name, String password) {
        return Database.LogIn(name, password);
    }
}