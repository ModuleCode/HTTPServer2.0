import com.modulecode.server.core.Application;
import com.modulecode.server.tools.ClassScanner;
import com.xg.Server;
import com.xg.ServletTest;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        Server server = new Server(8888);
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("/test");
//        server.addServlet(ServletTest.class, arrayList);
//        server.initServer();


        Application application = new Application("server.xml");
        application.start();


    }
}
