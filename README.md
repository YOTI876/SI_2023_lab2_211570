Александар Трајковски

211570
 
 
 
----Цикломатската комплексност на дадениот код = 11----

![Lab2_SI_num](https://github.com/YOTI876/SI_2023_lab2_211570/assets/82913978/d5d9f4f0-f4f4-471b-ac65-5e145421d8fd)


----if-ови = 10 + 6----

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

public class SILab2 { 

    public static boolean function (User user, List<User> allUsers) { 
        if (user==null || user.getPassword()==null || user.getEmail()==null){ 
            throw new RuntimeException("Mandatory information missing!"); 
        }

        if (user.getUsername()==null){ 
            user.setUsername(user.getEmail()); 
        }

        int same = 1; 
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {
            same = 0; 
            for (int i=0;i<allUsers.size();i++) { 
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { 
                    same += 1; 
                }
                if (existingUser.getUsername() == user.getUsername()) { 
                    same += 1;
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; 
        String password = user.getPassword(); 
        String passwordLower = password.toLowerCase(); 

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { 
            return false; 
        }
        else { 
            if (!passwordLower.contains(" ")) { 
                for (int i = 0; i < specialCharacters.length(); i++) {
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { 
                        return same == 0; 
                    }
                }
            }
        }
        return false; 
    }

}

![2023-05-30 18_31_41-Book1 - Excel](https://github.com/YOTI876/SI_2023_lab2_211570/assets/82913978/125ce0de-03ed-485d-a612-80c44b6afd7e)

1. user=null; Ќе помине

2. user.getPassword()=null; Првиот нема да помине | Вториот ќе помине

3. user.getEmail()=null; Првиот и вториот нема да поминат | Третиот ке помине

4. user!=null && user.getPassword()=null && user.getEmail()=null; Нема да поминат сите нагоре
