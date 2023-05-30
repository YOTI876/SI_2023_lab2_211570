import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) { 
        this.username = username; 
        this.password = password; 
        this.email = email; 
    }

    public String getUsername() { 
        return username; 
    }

    public void setUsername(String username){ 
        this.username=username; 
    }

    public String getPassword() { 
        return password; 
    }

    public String getEmail() { 
        return email; 
    }
}

public class SILab2 { //1

    public static boolean function (User user, List<User> allUsers) { //2
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //3
            throw new RuntimeException("Mandatory information missing!"); //4
        }

        if (user.getUsername()==null){ //5
            user.setUsername(user.getEmail()); //6
        }

        int same = 1; //7
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //8
            same = 0; //9
            for (int i=0;i<allUsers.size();i++) { //10
                User existingUser = allUsers.get(i); //11
                if (existingUser.getEmail() == user.getEmail()) { //12
                    same += 1; //13
                }
                if (existingUser.getUsername() == user.getUsername()) { //14
                    same += 1; //15
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //16
        String password = user.getPassword(); //17
        String passwordLower = password.toLowerCase(); //18

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //19
            return false; //20
        }
        else { //21
            if (!passwordLower.contains(" ")) { //22
                for (int i = 0; i < specialCharacters.length(); i++) { //23
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //24
                        return same == 0; //25
                    }
                }
            }
        }
        return false; //26
    }

}