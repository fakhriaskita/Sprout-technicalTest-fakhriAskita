package webelement;

import java.util.Vector;

public class PageObject {
    public String Table(String Name, Integer i){
        PageObject pg = new PageObject();
        switch(Name){
            case "Login":
                Vector<String> LoginExpected = new Vector<>(2);
                Vector<String> LoginActual = new Vector<>(2);
                LoginExpected.add("Swag Labs");
                LoginExpected.add("Login");
                LoginActual.add("//*[@id=\"root\"]/div/div[1]");
                LoginActual.add("//*[@id=\"login-button\"]");
                return LoginExpected.elementAt(i) + ";" + LoginActual.elementAt(i);
            case "LoginSucceed":
                Vector<String> LoginSucceedExpected = new Vector<>(2);
                Vector<String> LoginSucceedActual = new Vector<>(2);
                LoginSucceedExpected.add("Products");
                LoginSucceedExpected.add("Sauce Labs Backpack");
                LoginSucceedActual.add("//*[@id=\"header_container\"]/div[2]/span");
                LoginSucceedActual.add("//*[@id=\"item_4_title_link\"]/div");
                return LoginSucceedExpected.elementAt(i) + ";" + LoginSucceedActual.elementAt(i);
            case "LoginLocked":
                Vector<String> LoginLockedExpected = new Vector<>(2);
                Vector<String> LoginLockedActual = new Vector<>(2);
                LoginLockedExpected.add("locked_out_user");
                LoginLockedExpected.add("Sorry, this user has been locked out.");
                LoginLockedActual.add("//*[@id=\"user-name\"]");
                LoginLockedActual.add("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
                return LoginLockedExpected.elementAt(i) + ";" + LoginLockedActual.elementAt(i);
        }
        return Name;
    }
}
