package webelement;

public class Login {
    public String UI(String Name){
        String webelement ="";
        switch(Name){
            case "Login_Title":
                webelement="//*[@id=\"root\"]/div/div[1]";
                return webelement;
            case "Login_Username":
                webelement="//input[@id='user-name']";
                return webelement;
            case "Login_Password":
                webelement="//input[@id='password']";
                return webelement;
            case "Login_Submit":
                webelement="//input[@id='login-button']";
                return webelement;
            default:
                webelement="form-label";
                return webelement;
        }
    }
}
