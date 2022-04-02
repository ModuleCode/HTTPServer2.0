import com.modulecode.server.tools.ClassScanner;

import java.io.IOException;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassScanner scanner = new ClassScanner("com.modulecode", true, null, null);
        Set<Class<?>> packageAllClasses = scanner.doScanAllClasses();
        packageAllClasses.forEach(it -> {
            System.out.println(it);
        });
    }
}
