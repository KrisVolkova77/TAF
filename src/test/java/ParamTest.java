import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;

public class ParamTest {
    private String pass;

    @Parameters ({"Login-value","psv-value"})
    @Test
    public void paramTest(@Optional ("Default login") String login, @Optional("111111") String psv) {
        System.out.println("Login is" + login);
        System.out.println("Password is:" + pass);

    }
}
