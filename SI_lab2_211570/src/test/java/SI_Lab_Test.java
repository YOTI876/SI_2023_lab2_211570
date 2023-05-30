import org.junit.jupiter.api.*;
import java.util.*;
public class SI_Lab_Test
{
public SILab2 OPA = new SILab2();
User korisnik = new User("bla", "bla", "bla@gmail.com");
public ArrayList<User>bla = new ArrayList<>();

@Test
    void test1()
{
    //pass < 8
    User yo = new User(null, "1234567", "krom1d@gmail.com");
    Assertions.assertFalse(OPA.function(yo,bla));

    //exep
    User OO = new User(null, null, null);
    Assertions.assertThrows(RuntimeException.class, () -> OPA.function(OO,bla));

    //ako ima @ i .
    User wo = new User(null, "bla", "asjdlka12");
    Assertions.assertFalse(OPA.function(wo,bla));

    //if lower
    User hi = new User("woo", "woo", "woo");
    Assertions.assertFalse(OPA.function(hi,bla));
};
}
