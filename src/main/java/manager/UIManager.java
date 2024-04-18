package manager;
import webelement.Login;

public class UIManager {
    String webelement = "";

    public String FindElement(String Name) {
        if (Name.startsWith("Login_"))
        {Login ui = new Login(); webelement = ui.UI(Name);}

        return webelement;
    }
}
