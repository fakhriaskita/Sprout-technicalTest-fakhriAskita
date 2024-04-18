import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Login extends TestCase{
    public Login(String LoginSuccess)
    {
        super(LoginSuccess);
    }
    public static junit.framework.Test suite()
    {   controller.Login login = new controller.Login();
        String browser="chrome";Integer test=0;
        try{
            login.LoginSuccess(browser,test);
        } catch(Exception e){

        };
        return new TestSuite(AppTest.class);
    }
}